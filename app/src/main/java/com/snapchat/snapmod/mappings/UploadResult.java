package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class UploadResult extends MappedObject {
  public UploadResult() {
    this(new Object[0]);
  }

  public UploadResult(Object instance) {
    super(Mappings.get("UploadResult"), instance);
  }

  public UploadResult(Object[] args) {
    super(Mappings.get("UploadResult"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public MediaPackage getMediaPackage() {
    return MediaPackage.wrap(get("mediaPackage"));
  }

  public void setMediaPackage(MediaPackage value) {
    set("mediaPackage", value);
  }

  public static UploadResult wrap(Object instance) {
    return new UploadResult(instance);
  }
}
