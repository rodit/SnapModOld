package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class SnapPlaybackStatus extends MappedObject {
  public SnapPlaybackStatus() {
    this(new Object[0]);
  }

  public SnapPlaybackStatus(Object instance) {
    super(Mappings.get("SnapPlaybackStatus"), instance);
  }

  public SnapPlaybackStatus(Object[] args) {
    super(Mappings.get("SnapPlaybackStatus"), args);
  }

  public static SnapPlaybackStatus SAVED() {
    return SnapPlaybackStatus.wrap(getStatic("SnapPlaybackStatus", "SAVED"));
  }

  public static void SAVED(SnapPlaybackStatus value) {
    setStatic("SnapPlaybackStatus", "SAVED", value);
  }

  public static SnapPlaybackStatus PLAYING() {
    return SnapPlaybackStatus.wrap(getStatic("SnapPlaybackStatus", "PLAYING"));
  }

  public static void PLAYING(SnapPlaybackStatus value) {
    setStatic("SnapPlaybackStatus", "PLAYING", value);
  }

  public static SnapPlaybackStatus VIEWEDNOTREPLAYABLE() {
    return SnapPlaybackStatus.wrap(getStatic("SnapPlaybackStatus", "VIEWEDNOTREPLAYABLE"));
  }

  public static void VIEWEDNOTREPLAYABLE(SnapPlaybackStatus value) {
    setStatic("SnapPlaybackStatus", "VIEWEDNOTREPLAYABLE", value);
  }

  public static SnapPlaybackStatus NONE() {
    return SnapPlaybackStatus.wrap(getStatic("SnapPlaybackStatus", "NONE"));
  }

  public static void NONE(SnapPlaybackStatus value) {
    setStatic("SnapPlaybackStatus", "NONE", value);
  }

  public static SnapPlaybackStatus PLAYABLE() {
    return SnapPlaybackStatus.wrap(getStatic("SnapPlaybackStatus", "PLAYABLE"));
  }

  public static void PLAYABLE(SnapPlaybackStatus value) {
    setStatic("SnapPlaybackStatus", "PLAYABLE", value);
  }

  public static SnapPlaybackStatus VIEWEDREPLAYABLE() {
    return SnapPlaybackStatus.wrap(getStatic("SnapPlaybackStatus", "VIEWEDREPLAYABLE"));
  }

  public static void VIEWEDREPLAYABLE(SnapPlaybackStatus value) {
    setStatic("SnapPlaybackStatus", "VIEWEDREPLAYABLE", value);
  }

  public static SnapPlaybackStatus valueOf(String value) {
    return (SnapPlaybackStatus) Mappings.getEnumValue("SnapPlaybackStatus", value);
  }

  public static SnapPlaybackStatus wrap(Object instance) {
    return new SnapPlaybackStatus(instance);
  }
}
