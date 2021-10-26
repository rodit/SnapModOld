package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class UploadResultWaiter extends MappedObject {
  public UploadResultWaiter() {
    this(new Object[0]);
  }

  public UploadResultWaiter(Object instance) {
    super(Mappings.get("UploadResultWaiter"), instance);
  }

  public UploadResultWaiter(Object[] args) {
    super(Mappings.get("UploadResultWaiter"), args);
  }

  public Object apply(Object arg0) {
    return (Object) call("apply", arg0);
  }

  public MediaPackage getMediaPackage() {
    return MediaPackage.wrap(get("mediaPackage"));
  }

  public void setMediaPackage(MediaPackage value) {
    set("mediaPackage", value);
  }

  public static UploadResultWaiter wrap(Object instance) {
    return new UploadResultWaiter(instance);
  }
}
