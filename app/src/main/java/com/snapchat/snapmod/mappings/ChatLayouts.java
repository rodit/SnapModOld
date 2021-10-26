package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class ChatLayouts extends MappedObject {
  public ChatLayouts() {
    this(new Object[0]);
  }

  public ChatLayouts(Object instance) {
    super(Mappings.get("ChatLayouts"), instance);
  }

  public ChatLayouts(Object[] args) {
    super(Mappings.get("ChatLayouts"), args);
  }

  public int layoutId() {
    return (int) get("layoutId");
  }

  public void layoutId(int value) {
    set("layoutId", value);
  }

  public static ChatLayouts SNAP() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "SNAP"));
  }

  public static void SNAP(ChatLayouts value) {
    setStatic("ChatLayouts", "SNAP", value);
  }

  public static ChatLayouts SAVED_SNAP() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "SAVED_SNAP"));
  }

  public static void SAVED_SNAP(ChatLayouts value) {
    setStatic("ChatLayouts", "SAVED_SNAP", value);
  }

  public static ChatLayouts AUDIO_NOTE() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "AUDIO_NOTE"));
  }

  public static void AUDIO_NOTE(ChatLayouts value) {
    setStatic("ChatLayouts", "AUDIO_NOTE", value);
  }

  public static ChatLayouts UNKNOWN() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "UNKNOWN"));
  }

  public static void UNKNOWN(ChatLayouts value) {
    setStatic("ChatLayouts", "UNKNOWN", value);
  }

  public static ChatLayouts CHAT_MEDIA() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "CHAT_MEDIA"));
  }

  public static void CHAT_MEDIA(ChatLayouts value) {
    setStatic("ChatLayouts", "CHAT_MEDIA", value);
  }

  public static ChatLayouts MEMORIES_STORY() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "MEMORIES_STORY"));
  }

  public static void MEMORIES_STORY(ChatLayouts value) {
    setStatic("ChatLayouts", "MEMORIES_STORY", value);
  }

  public static ChatLayouts TEXT_STORY_REPLY() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "TEXT_STORY_REPLY"));
  }

  public static void TEXT_STORY_REPLY(ChatLayouts value) {
    setStatic("ChatLayouts", "TEXT_STORY_REPLY", value);
  }

  public static ChatLayouts TEXT_WITH_MEDIA_CARDS() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "TEXT_WITH_MEDIA_CARDS"));
  }

  public static void TEXT_WITH_MEDIA_CARDS(ChatLayouts value) {
    setStatic("ChatLayouts", "TEXT_WITH_MEDIA_CARDS", value);
  }

  public static ChatLayouts ERASE() {
    return ChatLayouts.wrap(getStatic("ChatLayouts", "ERASE"));
  }

  public static void ERASE(ChatLayouts value) {
    setStatic("ChatLayouts", "ERASE", value);
  }

  public static ChatLayouts valueOf(String value) {
    return (ChatLayouts) Mappings.getEnumValue("ChatLayouts", value);
  }

  public static ChatLayouts wrap(Object instance) {
    return new ChatLayouts(instance);
  }
}
