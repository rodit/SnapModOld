package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;
import java.util.Map;

public class ChatModelSavedSnap extends MappedObject {
  public ChatModelSavedSnap(Object arg0, MessageDataModel arg1, String arg2, Map arg3, boolean arg4,
      ChatReactionsBelowMessageViewModel arg5, boolean arg6, int arg7, int arg8, LiveSnapMedia arg9,
      String arg10, MediaDownloadStatus arg11, boolean arg12) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12 });
  }

  public ChatModelSavedSnap() {
    this(new Object[0]);
  }

  public ChatModelSavedSnap(Object instance) {
    super(Mappings.get("ChatModelSavedSnap"), instance);
  }

  public ChatModelSavedSnap(Object[] args) {
    super(Mappings.get("ChatModelSavedSnap"), args);
  }

  public LiveSnapMedia getMedia() {
    return LiveSnapMedia.wrap(get("media"));
  }

  public void setMedia(LiveSnapMedia value) {
    set("media", value);
  }

  public MediaType getMediaType() {
    return MediaType.wrap(get("mediaType"));
  }

  public void setMediaType(MediaType value) {
    set("mediaType", value);
  }

  public static ChatModelSavedSnap wrap(Object instance) {
    return new ChatModelSavedSnap(instance);
  }
}
