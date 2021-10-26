package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class MediaPackage extends MappedObject {
  public MediaPackage() {
    this(new Object[0]);
  }

  public MediaPackage(Object instance) {
    super(Mappings.get("MediaPackage"), instance);
  }

  public MediaPackage(Object[] args) {
    super(Mappings.get("MediaPackage"), args);
  }

  public String getMediaId() {
    return (java.lang.String) get("mediaId");
  }

  public void setMediaId(String value) {
    set("mediaId", value);
  }

  public String getSessionId() {
    return (java.lang.String) get("sessionId");
  }

  public void setSessionId(String value) {
    set("sessionId", value);
  }

  public String getContentId() {
    return (java.lang.String) get("contentId");
  }

  public void setContentId(String value) {
    set("contentId", value);
  }

  public static MediaPackage wrap(Object instance) {
    return new MediaPackage(instance);
  }
}
