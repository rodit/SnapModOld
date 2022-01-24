package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class StoryMedia extends MappedObject {
  public StoryMedia() {
    this(new Object[0]);
  }

  public StoryMedia(Object instance) {
    super(Mappings.get("StoryMedia"), instance);
  }

  public StoryMedia(Object[] args) {
    super(Mappings.get("StoryMedia"), args);
  }

  public static StoryMedia wrap(Object instance) {
    return new StoryMedia(instance);
  }
}
