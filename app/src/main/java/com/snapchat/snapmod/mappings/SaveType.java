package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class SaveType extends MappedObject {
  public SaveType() {
    this(new Object[0]);
  }

  public SaveType(Object instance) {
    super(Mappings.get("SaveType"), instance);
  }

  public SaveType(Object[] args) {
    super(Mappings.get("SaveType"), args);
  }

  public static SaveType SNAPCHAT_ALBUM() {
    return SaveType.wrap(getStatic("SaveType", "SNAPCHAT_ALBUM"));
  }

  public static void SNAPCHAT_ALBUM(SaveType value) {
    setStatic("SaveType", "SNAPCHAT_ALBUM", value);
  }

  public static SaveType EMAIL() {
    return SaveType.wrap(getStatic("SaveType", "EMAIL"));
  }

  public static void EMAIL(SaveType value) {
    setStatic("SaveType", "EMAIL", value);
  }

  public static SaveType SPECTACLES_ALBUM() {
    return SaveType.wrap(getStatic("SaveType", "SPECTACLES_ALBUM"));
  }

  public static void SPECTACLES_ALBUM(SaveType value) {
    setStatic("SaveType", "SPECTACLES_ALBUM", value);
  }

  public static SaveType SMS() {
    return SaveType.wrap(getStatic("SaveType", "SMS"));
  }

  public static void SMS(SaveType value) {
    setStatic("SaveType", "SMS", value);
  }

  public static SaveType EXTERNAL_APPS() {
    return SaveType.wrap(getStatic("SaveType", "EXTERNAL_APPS"));
  }

  public static void EXTERNAL_APPS(SaveType value) {
    setStatic("SaveType", "EXTERNAL_APPS", value);
  }

  public static SaveType valueOf(String value) {
    return (SaveType) Mappings.getEnumValue("SaveType", value);
  }

  public static SaveType wrap(Object instance) {
    return new SaveType(instance);
  }
}
