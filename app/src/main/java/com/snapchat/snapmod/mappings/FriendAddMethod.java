package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class FriendAddMethod extends MappedObject {
  public FriendAddMethod() {
    this(new Object[0]);
  }

  public FriendAddMethod(Object instance) {
    super(Mappings.get("FriendAddMethod"), instance);
  }

  public FriendAddMethod(Object[] args) {
    super(Mappings.get("FriendAddMethod"), args);
  }

  public static FriendAddMethod ADDED_BY_SHARED_STORY() {
    return FriendAddMethod.wrap(getStatic("FriendAddMethod", "ADDED_BY_SHARED_STORY"));
  }

  public static void ADDED_BY_SHARED_STORY(FriendAddMethod value) {
    setStatic("FriendAddMethod", "ADDED_BY_SHARED_STORY", value);
  }

  public static FriendAddMethod ADDED_BY_ADDED_ME_BACK() {
    return FriendAddMethod.wrap(getStatic("FriendAddMethod", "ADDED_BY_ADDED_ME_BACK"));
  }

  public static void ADDED_BY_ADDED_ME_BACK(FriendAddMethod value) {
    setStatic("FriendAddMethod", "ADDED_BY_ADDED_ME_BACK", value);
  }

  public static FriendAddMethod ADDED_BY_USERNAME() {
    return FriendAddMethod.wrap(getStatic("FriendAddMethod", "ADDED_BY_USERNAME"));
  }

  public static void ADDED_BY_USERNAME(FriendAddMethod value) {
    setStatic("FriendAddMethod", "ADDED_BY_USERNAME", value);
  }

  public static FriendAddMethod ADDED_BY_SHARED_USERNAME() {
    return FriendAddMethod.wrap(getStatic("FriendAddMethod", "ADDED_BY_SHARED_USERNAME"));
  }

  public static void ADDED_BY_SHARED_USERNAME(FriendAddMethod value) {
    setStatic("FriendAddMethod", "ADDED_BY_SHARED_USERNAME", value);
  }

  public static FriendAddMethod ADDED_BY_GROUP_CHAT() {
    return FriendAddMethod.wrap(getStatic("FriendAddMethod", "ADDED_BY_GROUP_CHAT"));
  }

  public static void ADDED_BY_GROUP_CHAT(FriendAddMethod value) {
    setStatic("FriendAddMethod", "ADDED_BY_GROUP_CHAT", value);
  }

  public static FriendAddMethod ADDED_BY_SUGGESTED() {
    return FriendAddMethod.wrap(getStatic("FriendAddMethod", "ADDED_BY_SUGGESTED"));
  }

  public static void ADDED_BY_SUGGESTED(FriendAddMethod value) {
    setStatic("FriendAddMethod", "ADDED_BY_SUGGESTED", value);
  }

  public static FriendAddMethod valueOf(String value) {
    return (FriendAddMethod) Mappings.getEnumValue("FriendAddMethod", value);
  }

  public static FriendAddMethod wrap(Object instance) {
    return new FriendAddMethod(instance);
  }
}
