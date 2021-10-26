package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.util.Set;

public class BitmojiUriHandler extends MappedObject {
  public BitmojiUriHandler(Object arg0, Object arg1, Object arg2, Object arg3, Object arg4,
      Object arg5, Object arg6) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6 });
  }

  public BitmojiUriHandler() {
    this(new Object[0]);
  }

  public BitmojiUriHandler(Object instance) {
    super(Mappings.get("BitmojiUriHandler"), instance);
  }

  public BitmojiUriHandler(Object[] args) {
    super(Mappings.get("BitmojiUriHandler"), args);
  }

  public RxSupplier handle(Object arg0, Set arg1, boolean arg2, Set arg3) {
    return RxSupplier.wrap(call("handle", arg0, arg1, arg2, arg3));
  }

  public static BitmojiUriHandler wrap(Object instance) {
    return new BitmojiUriHandler(instance);
  }
}
