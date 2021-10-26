package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class ChatModelBase extends MappedObject {
  public ChatModelBase() {
    this(new Object[0]);
  }

  public ChatModelBase(Object instance) {
    super(Mappings.get("ChatModelBase"), instance);
  }

  public ChatModelBase(Object[] args) {
    super(Mappings.get("ChatModelBase"), args);
  }

  public boolean canSave() {
    return (boolean) call("canSave", new Object[0]);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public SaveType getSaveType() {
    return SaveType.wrap(call("getSaveType", new Object[0]));
  }

  public boolean getBoolField() {
    return (boolean) get("boolField");
  }

  public void setBoolField(boolean value) {
    set("boolField", value);
  }

  public Object getContext() {
    return (Object) get("context");
  }

  public void setContext(Object value) {
    set("context", value);
  }

  public MessageDataModel getMessageData() {
    return MessageDataModel.wrap(get("messageData"));
  }

  public void setMessageData(MessageDataModel value) {
    set("messageData", value);
  }

  public String getSenderId() {
    return (java.lang.String) get("senderId");
  }

  public void setSenderId(String value) {
    set("senderId", value);
  }

  public ChatLayouts getChatLayout() {
    return ChatLayouts.wrap(get("chatLayout"));
  }

  public void setChatLayout(ChatLayouts value) {
    set("chatLayout", value);
  }

  public ChatReactionsBelowMessageViewModel getReactionsViewModel() {
    return ChatReactionsBelowMessageViewModel.wrap(get("reactionsViewModel"));
  }

  public void setReactionsViewModel(ChatReactionsBelowMessageViewModel value) {
    set("reactionsViewModel", value);
  }

  public MediaDownloadStatus getStatus() {
    return MediaDownloadStatus.wrap(get("status"));
  }

  public void setStatus(MediaDownloadStatus value) {
    set("status", value);
  }

  public static ChatModelBase wrap(Object instance) {
    return new ChatModelBase(instance);
  }
}
