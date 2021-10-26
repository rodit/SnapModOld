package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.util.Set;

public class ChatMediaHandler extends MappedObject {
  public ChatMediaHandler() {
    this(new Object[0]);
  }

  public ChatMediaHandler(Object instance) {
    super(Mappings.get("ChatMediaHandler"), instance);
  }

  public ChatMediaHandler(Object[] args) {
    super(Mappings.get("ChatMediaHandler"), args);
  }

  public RxSupplier resolve(Object arg0, Set arg1, boolean arg2, Set arg3) {
    return RxSupplier.wrap(call("resolve", arg0, arg1, arg2, arg3));
  }

  public static ChatMediaHandler wrap(Object instance) {
    return new ChatMediaHandler(instance);
  }
}
