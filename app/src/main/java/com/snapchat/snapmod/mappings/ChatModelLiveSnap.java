package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;
import java.util.Map;

public class ChatModelLiveSnap extends MappedObject {
  public ChatModelLiveSnap(Object arg0, ChatLayouts arg1, MediaDownloadStatus arg2,
      SnapPlaybackStatus arg3, Object arg4, MessageDataModel arg5, LiveSnapMedia arg6, String arg7,
      Map arg8, boolean arg9, ChatReactionsBelowMessageViewModel arg10, boolean arg11, String arg12,
      Object arg13, Object arg14, Object arg15) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15 });
  }

  public ChatModelLiveSnap() {
    this(new Object[0]);
  }

  public ChatModelLiveSnap(Object instance) {
    super(Mappings.get("ChatModelLiveSnap"), instance);
  }

  public ChatModelLiveSnap(Object[] args) {
    super(Mappings.get("ChatModelLiveSnap"), args);
  }

  public static ChatModelLiveSnap wrap(Object instance) {
    return new ChatModelLiveSnap(instance);
  }
}
