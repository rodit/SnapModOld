package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class MessageDataModel extends MappedObject {
  public MessageDataModel() {
    this(new Object[0]);
  }

  public MessageDataModel(Object instance) {
    super(Mappings.get("MessageDataModel"), instance);
  }

  public MessageDataModel(Object[] args) {
    super(Mappings.get("MessageDataModel"), args);
  }

  public SnapPlaybackStatus getPlaybackStatus() {
    return SnapPlaybackStatus.wrap(call("getPlaybackStatus", new Object[0]));
  }

  public MessageState getMessageState() {
    return MessageState.wrap(call("getMessageState", new Object[0]));
  }

  public static MessageDataModel wrap(Object instance) {
    return new MessageDataModel(instance);
  }
}
