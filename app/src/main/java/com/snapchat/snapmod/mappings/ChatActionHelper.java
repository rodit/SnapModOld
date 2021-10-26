package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class ChatActionHelper extends MappedObject {
  public ChatActionHelper(Object arg0, Object arg1, Object arg2, Object arg3, Object arg4,
      Object arg5, Object arg6, Object arg7, Object arg8) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8 });
  }

  public ChatActionHelper() {
    this(new Object[0]);
  }

  public ChatActionHelper(Object instance) {
    super(Mappings.get("ChatActionHelper"), instance);
  }

  public ChatActionHelper(Object[] args) {
    super(Mappings.get("ChatActionHelper"), args);
  }

  public boolean canSave(ChatModelBase arg0, boolean arg1) {
    return (boolean) call("canSave", arg0, arg1);
  }

  public static ChatActionHelper wrap(Object instance) {
    return new ChatActionHelper(instance);
  }
}
