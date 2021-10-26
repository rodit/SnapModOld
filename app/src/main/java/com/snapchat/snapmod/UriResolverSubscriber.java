package com.snapchat.snapmod;

import com.snapchat.snapmod.mappings.MediaStreamProvider;
import com.util.mappings.ClassMapping;
import com.util.mappings.Mappings;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import de.robv.android.xposed.XposedBridge;

public class UriResolverSubscriber implements InvocationHandler {

    private final ResolutionListener listener;

    public UriResolverSubscriber(ResolutionListener listener) {
        this.listener = listener;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ClassMapping mapping = Mappings.get("RxObserver");
        if (method.getName().equals(mapping.getDexMethod("accept"))) {
            if (listener != null) {
                listener.accept(args[0]);
            }
        } else if(method.getName().equals(mapping.getDexMethod("error"))) {
            XposedBridge.log("Error while resolving uri.");
            XposedBridge.log((Throwable)args[0]);
        }
        return null;
    }

    public static class MediaUriDownloader extends UriResolverSubscriber {

        public MediaUriDownloader(File dest) {
            super(new UriListener(dest));
        }

        private static class UriListener implements ResolutionListener {

            private final File dest;

            public UriListener(File dest) {
                this.dest = dest;
            }

            @Override
            public void accept(Object result) {
                MediaStreamProvider streamProvider = MediaStreamProvider.wrap(result);
                Streams.copy(streamProvider.getMediaStream(), dest);
                XposedBridge.log("Downloaded resolved media to " + dest);
            }
        }
    }

    public interface ResolutionListener {

        void accept(Object result);
    }
}
