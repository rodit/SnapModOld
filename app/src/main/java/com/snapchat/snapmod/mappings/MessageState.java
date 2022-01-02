package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class MessageState extends MappedObject {
  public MessageState() {
    this(new Object[0]);
  }

  public MessageState(Object instance) {
    super(Mappings.get("MessageState"), instance);
  }

  public MessageState(Object[] args) {
    super(Mappings.get("MessageState"), args);
  }

  public static MessageState DELIVERED() {
    return MessageState.wrap(getStatic("MessageState", "DELIVERED"));
  }

  public static void DELIVERED(MessageState value) {
    setStatic("MessageState", "DELIVERED", value);
  }

  public static MessageState NONE() {
    return MessageState.wrap(getStatic("MessageState", "NONE"));
  }

  public static void NONE(MessageState value) {
    setStatic("MessageState", "NONE", value);
  }

  public static MessageState SENT() {
    return MessageState.wrap(getStatic("MessageState", "SENT"));
  }

  public static void SENT(MessageState value) {
    setStatic("MessageState", "SENT", value);
  }

  public static MessageState VIEWED() {
    return MessageState.wrap(getStatic("MessageState", "VIEWED"));
  }

  public static void VIEWED(MessageState value) {
    setStatic("MessageState", "VIEWED", value);
  }

  public static MessageState PENDING() {
    return MessageState.wrap(getStatic("MessageState", "PENDING"));
  }

  public static void PENDING(MessageState value) {
    setStatic("MessageState", "PENDING", value);
  }

  public static MessageState SCREENSHOT() {
    return MessageState.wrap(getStatic("MessageState", "SCREENSHOT"));
  }

  public static void SCREENSHOT(MessageState value) {
    setStatic("MessageState", "SCREENSHOT", value);
  }

  public static MessageState valueOf(String value) {
    return (MessageState) Mappings.getEnumValue("MessageState", value);
  }

  public static MessageState wrap(Object instance) {
    return new MessageState(instance);
  }
}
