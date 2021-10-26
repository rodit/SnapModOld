package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class GallerySnapMedia extends MappedObject {
  public GallerySnapMedia() {
    this(new Object[0]);
  }

  public GallerySnapMedia(Object instance) {
    super(Mappings.get("GallerySnapMedia"), instance);
  }

  public GallerySnapMedia(Object[] args) {
    super(Mappings.get("GallerySnapMedia"), args);
  }

  public String getMediaType() {
    return (String) call("getMediaType", new Object[0]);
  }

  public MediaItem getMedia() {
    return MediaItem.wrap(get("media"));
  }

  public void setMedia(MediaItem value) {
    set("media", value);
  }

  public static GallerySnapMedia wrap(Object instance) {
    return new GallerySnapMedia(instance);
  }
}
