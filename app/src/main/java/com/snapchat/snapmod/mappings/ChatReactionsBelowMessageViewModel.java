package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class ChatReactionsBelowMessageViewModel extends MappedObject {
  public ChatReactionsBelowMessageViewModel() {
    this(new Object[0]);
  }

  public ChatReactionsBelowMessageViewModel(Object instance) {
    super(Mappings.get("ChatReactionsBelowMessageViewModel"), instance);
  }

  public ChatReactionsBelowMessageViewModel(Object[] args) {
    super(Mappings.get("ChatReactionsBelowMessageViewModel"), args);
  }

  public static ChatReactionsBelowMessageViewModel wrap(Object instance) {
    return new ChatReactionsBelowMessageViewModel(instance);
  }
}
