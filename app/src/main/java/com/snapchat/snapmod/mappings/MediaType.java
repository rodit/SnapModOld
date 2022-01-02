package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class MediaType extends MappedObject {
  public MediaType() {
    this(new Object[0]);
  }

  public MediaType(Object instance) {
    super(Mappings.get("MediaType"), instance);
  }

  public MediaType(Object[] args) {
    super(Mappings.get("MediaType"), args);
  }

  public static MediaType IMAGE() {
    return MediaType.wrap(getStatic("MediaType", "IMAGE"));
  }

  public static void IMAGE(MediaType value) {
    setStatic("MediaType", "IMAGE", value);
  }

  public static MediaType VIDEO() {
    return MediaType.wrap(getStatic("MediaType", "VIDEO"));
  }

  public static void VIDEO(MediaType value) {
    setStatic("MediaType", "VIDEO", value);
  }

  public static MediaType VIDEO_NO_SOUND() {
    return MediaType.wrap(getStatic("MediaType", "VIDEO_NO_SOUND"));
  }

  public static void VIDEO_NO_SOUND(MediaType value) {
    setStatic("MediaType", "VIDEO_NO_SOUND", value);
  }

  public static MediaType valueOf(String value) {
    return (MediaType) Mappings.getEnumValue("MediaType", value);
  }

  public static MediaType wrap(Object instance) {
    return new MediaType(instance);
  }
}
