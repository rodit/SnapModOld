package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;
import java.util.List;

public class MessageSenderCrossroad extends MappedObject {
  public MessageSenderCrossroad(Object arg0, List arg1, Object arg2, String arg3, Object arg4,
      List arg5, Object arg6) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6 });
  }

  public MessageSenderCrossroad() {
    this(new Object[0]);
  }

  public MessageSenderCrossroad(Object instance) {
    super(Mappings.get("MessageSenderCrossroad"), instance);
  }

  public MessageSenderCrossroad(Object[] args) {
    super(Mappings.get("MessageSenderCrossroad"), args);
  }

  public Object apply(Object arg0) {
    return (Object) call("apply", arg0);
  }

  public Object getMedia() {
    return (Object) get("media");
  }

  public void setMedia(Object value) {
    set("media", value);
  }

  public static MessageSenderCrossroad wrap(Object instance) {
    return new MessageSenderCrossroad(instance);
  }
}
