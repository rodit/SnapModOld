package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class LiveSnapMedia extends MappedObject {
  public LiveSnapMedia() {
    this(new Object[0]);
  }

  public LiveSnapMedia(Object instance) {
    super(Mappings.get("LiveSnapMedia"), instance);
  }

  public LiveSnapMedia(Object[] args) {
    super(Mappings.get("LiveSnapMedia"), args);
  }

  public MediaType getMediaType() {
    return MediaType.wrap(get("mediaType"));
  }

  public void setMediaType(MediaType value) {
    set("mediaType", value);
  }

  public ParameterPackage getParameterPackage() {
    return ParameterPackage.wrap(get("parameterPackage"));
  }

  public void setParameterPackage(ParameterPackage value) {
    set("parameterPackage", value);
  }

  public String getMediaId() {
    return (java.lang.String) get("mediaId");
  }

  public void setMediaId(String value) {
    set("mediaId", value);
  }

  public MediaItemLocator getLocator() {
    return MediaItemLocator.wrap(get("locator"));
  }

  public void setLocator(MediaItemLocator value) {
    set("locator", value);
  }

  public static LiveSnapMedia wrap(Object instance) {
    return new LiveSnapMedia(instance);
  }
}
