package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class ContentType extends MappedObject {
  public ContentType() {
    this(new Object[0]);
  }

  public ContentType(Object instance) {
    super(Mappings.get("ContentType"), instance);
  }

  public ContentType(Object[] args) {
    super(Mappings.get("ContentType"), args);
  }

  public static ContentType CHAT() {
    return ContentType.wrap(getStatic("ContentType", "CHAT"));
  }

  public static void CHAT(ContentType value) {
    setStatic("ContentType", "CHAT", value);
  }

  public static ContentType SNAP() {
    return ContentType.wrap(getStatic("ContentType", "SNAP"));
  }

  public static void SNAP(ContentType value) {
    setStatic("ContentType", "SNAP", value);
  }

  public static ContentType STATUS_SAVE_TO_CAMERA_ROLL() {
    return ContentType.wrap(getStatic("ContentType", "STATUS_SAVE_TO_CAMERA_ROLL"));
  }

  public static void STATUS_SAVE_TO_CAMERA_ROLL(ContentType value) {
    setStatic("ContentType", "STATUS_SAVE_TO_CAMERA_ROLL", value);
  }

  public static ContentType LOCATION() {
    return ContentType.wrap(getStatic("ContentType", "LOCATION"));
  }

  public static void LOCATION(ContentType value) {
    setStatic("ContentType", "LOCATION", value);
  }

  public static ContentType STATUS_CONVERSATION_CAPTURE_SCREENSHOT() {
    return ContentType.wrap(getStatic("ContentType", "STATUS_CONVERSATION_CAPTURE_SCREENSHOT"));
  }

  public static void STATUS_CONVERSATION_CAPTURE_SCREENSHOT(ContentType value) {
    setStatic("ContentType", "STATUS_CONVERSATION_CAPTURE_SCREENSHOT", value);
  }

  public static ContentType STATUS_CONVERSATION_CAPTURE_RECORD() {
    return ContentType.wrap(getStatic("ContentType", "STATUS_CONVERSATION_CAPTURE_RECORD"));
  }

  public static void STATUS_CONVERSATION_CAPTURE_RECORD(ContentType value) {
    setStatic("ContentType", "STATUS_CONVERSATION_CAPTURE_RECORD", value);
  }

  public static ContentType UNKNOWN() {
    return ContentType.wrap(getStatic("ContentType", "UNKNOWN"));
  }

  public static void UNKNOWN(ContentType value) {
    setStatic("ContentType", "UNKNOWN", value);
  }

  public static ContentType valueOf(String value) {
    return (ContentType) Mappings.getEnumValue("ContentType", value);
  }

  public static ContentType wrap(Object instance) {
    return new ContentType(instance);
  }
}
