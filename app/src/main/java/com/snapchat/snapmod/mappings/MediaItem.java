package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class MediaItem extends MappedObject {
  public MediaItem() {
    this(new Object[0]);
  }

  public MediaItem(Object instance) {
    super(Mappings.get("MediaItem"), instance);
  }

  public MediaItem(Object[] args) {
    super(Mappings.get("MediaItem"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public static MediaItem wrap(Object instance) {
    return new MediaItem(instance);
  }
}
