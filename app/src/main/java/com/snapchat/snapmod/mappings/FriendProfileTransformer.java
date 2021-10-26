package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class FriendProfileTransformer extends MappedObject {
  public FriendProfileTransformer() {
    this(new Object[0]);
  }

  public FriendProfileTransformer(Object instance) {
    super(Mappings.get("FriendProfileTransformer"), instance);
  }

  public FriendProfileTransformer(Object[] args) {
    super(Mappings.get("FriendProfileTransformer"), args);
  }

  public Object apply(Object arg0) {
    return (Object) call("apply", arg0);
  }

  public static FriendProfileTransformer wrap(Object instance) {
    return new FriendProfileTransformer(instance);
  }
}
