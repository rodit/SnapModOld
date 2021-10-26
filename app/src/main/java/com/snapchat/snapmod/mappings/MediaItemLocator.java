package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;

public class MediaItemLocator extends MappedObject {
  public MediaItemLocator() {
    this(new Object[0]);
  }

  public MediaItemLocator(Object instance) {
    super(Mappings.get("MediaItemLocator"), instance);
  }

  public MediaItemLocator(Object[] args) {
    super(Mappings.get("MediaItemLocator"), args);
  }

  public String getRegion() {
    return (java.lang.String) get("region");
  }

  public void setRegion(String value) {
    set("region", value);
  }

  public Long getExpirySecs() {
    return (java.lang.Long) get("expirySecs");
  }

  public void setExpirySecs(Long value) {
    set("expirySecs", value);
  }

  public String getUrl() {
    return (java.lang.String) get("url");
  }

  public void setUrl(String value) {
    set("url", value);
  }

  public String getType() {
    return (java.lang.String) get("type");
  }

  public void setType(String value) {
    set("type", value);
  }

  public static MediaItemLocator wrap(Object instance) {
    return new MediaItemLocator(instance);
  }
}
