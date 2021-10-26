package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.io.InputStream;
import java.lang.Object;

public class MediaStreamProvider extends MappedObject {
  public MediaStreamProvider() {
    this(new Object[0]);
  }

  public MediaStreamProvider(Object instance) {
    super(Mappings.get("MediaStreamProvider"), instance);
  }

  public MediaStreamProvider(Object[] args) {
    super(Mappings.get("MediaStreamProvider"), args);
  }

  public InputStream getMediaStream() {
    return (InputStream) call("getMediaStream", new Object[0]);
  }

  public void dispose() {
    call("dispose", new Object[0]);
  }

  public static MediaStreamProvider wrap(Object instance) {
    return new MediaStreamProvider(instance);
  }
}
