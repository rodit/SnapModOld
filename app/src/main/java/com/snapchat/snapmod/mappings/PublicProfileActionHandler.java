package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class PublicProfileActionHandler extends MappedObject {
  public PublicProfileActionHandler(Object arg0, Object arg1, Object arg2, Object arg3, Object arg4,
      Object arg5, Object arg6, Object arg7, Object arg8, Object arg9) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9 });
  }

  public PublicProfileActionHandler() {
    this(new Object[0]);
  }

  public PublicProfileActionHandler(Object instance) {
    super(Mappings.get("PublicProfileActionHandler"), instance);
  }

  public PublicProfileActionHandler(Object[] args) {
    super(Mappings.get("PublicProfileActionHandler"), args);
  }

  public void reportProfile(byte[] arg0) {
    call("reportProfile", arg0);
  }

  public static PublicProfileActionHandler wrap(Object instance) {
    return new PublicProfileActionHandler(instance);
  }
}
