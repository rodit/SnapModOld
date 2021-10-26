package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class FriendActionClient extends MappedObject {
  public FriendActionClient(Object arg0, Object arg1, Object arg2, Object arg3, Object arg4,
      Object arg5) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5 });
  }

  public FriendActionClient() {
    this(new Object[0]);
  }

  public FriendActionClient(Object instance) {
    super(Mappings.get("FriendActionClient"), instance);
  }

  public FriendActionClient(Object[] args) {
    super(Mappings.get("FriendActionClient"), args);
  }

  public RxSupplier sendFriendAction(FriendActionRequest arg0) {
    return RxSupplier.wrap(call("sendFriendAction", arg0));
  }

  public static FriendActionClient wrap(Object instance) {
    return new FriendActionClient(instance);
  }
}
