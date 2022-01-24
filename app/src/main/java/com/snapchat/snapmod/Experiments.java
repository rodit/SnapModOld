package com.snapchat.snapmod;

import com.util.mappings.Mappings;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class Experiments {

    public static void hookAll() {
        //composerHooks();
    }

    public static void composerHooks() {
        Class<?> ComposerRootView = XposedHelpers.findClass("com.snap.composer.views.ComposerRootView", Mappings.getClassLoader());
        Class<?> RC7 = XposedHelpers.findClass("RC7", Mappings.getClassLoader());
        Class<?> g8x = XposedHelpers.findClass("g8x", Mappings.getClassLoader());

        XposedHelpers.findAndHookMethod("Wv7", Mappings.getClassLoader(), "U0", ComposerRootView, String.class, Object.class, Object.class, RC7, g8x, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                String viewName = (String) param.args[1];
                Object model = param.args[2];
                XposedBridge.log(viewName + ": " + (model != null ? model.getClass() : "null model"));
                XposedBridge.log(String.valueOf(model));
            }
        });
    }
}
