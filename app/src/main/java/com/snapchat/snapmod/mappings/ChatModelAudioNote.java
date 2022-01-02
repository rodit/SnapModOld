package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;
import java.util.Map;

public class ChatModelAudioNote extends MappedObject {
  public ChatModelAudioNote(Object arg0, ChatLayouts arg1, MessageDataModel arg2,
      GallerySnapMedia arg3, String arg4, Map arg5, boolean arg6,
      ChatReactionsBelowMessageViewModel arg7, boolean arg8, QuotedMessageViewModel arg9) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9 });
  }

  public ChatModelAudioNote() {
    this(new Object[0]);
  }

  public ChatModelAudioNote(Object instance) {
    super(Mappings.get("ChatModelAudioNote"), instance);
  }

  public ChatModelAudioNote(Object[] args) {
    super(Mappings.get("ChatModelAudioNote"), args);
  }

  public Object getUri() {
    return (Object) call("getUri", new Object[0]);
  }

  public static ChatModelAudioNote wrap(Object instance) {
    return new ChatModelAudioNote(instance);
  }
}
