package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class MessageUpdate extends MappedObject {
  public MessageUpdate() {
    this(new Object[0]);
  }

  public MessageUpdate(Object instance) {
    super(Mappings.get("MessageUpdate"), instance);
  }

  public MessageUpdate(Object[] args) {
    super(Mappings.get("MessageUpdate"), args);
  }

  public static MessageUpdate UNKNOWN() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "UNKNOWN"));
  }

  public static void UNKNOWN(MessageUpdate value) {
    setStatic("MessageUpdate", "UNKNOWN", value);
  }

  public static MessageUpdate RELEASE() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "RELEASE"));
  }

  public static void RELEASE(MessageUpdate value) {
    setStatic("MessageUpdate", "RELEASE", value);
  }

  public static MessageUpdate READ() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "READ"));
  }

  public static void READ(MessageUpdate value) {
    setStatic("MessageUpdate", "READ", value);
  }

  public static MessageUpdate ERASE() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "ERASE"));
  }

  public static void ERASE(MessageUpdate value) {
    setStatic("MessageUpdate", "ERASE", value);
  }

  public static MessageUpdate SAVE() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "SAVE"));
  }

  public static void SAVE(MessageUpdate value) {
    setStatic("MessageUpdate", "SAVE", value);
  }

  public static MessageUpdate SCREEN_RECORD() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "SCREEN_RECORD"));
  }

  public static void SCREEN_RECORD(MessageUpdate value) {
    setStatic("MessageUpdate", "SCREEN_RECORD", value);
  }

  public static MessageUpdate REPLAY() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "REPLAY"));
  }

  public static void REPLAY(MessageUpdate value) {
    setStatic("MessageUpdate", "REPLAY", value);
  }

  public static MessageUpdate SCREENSHOT() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "SCREENSHOT"));
  }

  public static void SCREENSHOT(MessageUpdate value) {
    setStatic("MessageUpdate", "SCREENSHOT", value);
  }

  public static MessageUpdate UNSAVE() {
    return MessageUpdate.wrap(getStatic("MessageUpdate", "UNSAVE"));
  }

  public static void UNSAVE(MessageUpdate value) {
    setStatic("MessageUpdate", "UNSAVE", value);
  }

  public static MessageUpdate valueOf(String value) {
    return (MessageUpdate) Mappings.getEnumValue("MessageUpdate", value);
  }

  public static MessageUpdate wrap(Object instance) {
    return new MessageUpdate(instance);
  }
}
