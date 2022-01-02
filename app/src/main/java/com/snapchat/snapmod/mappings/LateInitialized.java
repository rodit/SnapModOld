package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class LateInitialized extends MappedObject {
  public LateInitialized() {
    this(new Object[0]);
  }

  public LateInitialized(Object instance) {
    super(Mappings.get("LateInitialized"), instance);
  }

  public LateInitialized(Object[] args) {
    super(Mappings.get("LateInitialized"), args);
  }

  public boolean isInitialized() {
    return (boolean) call("isInitialized", new Object[0]);
  }

  public Object getValue() {
    return (Object) call("getValue", new Object[0]);
  }

  public static LateInitialized wrap(Object instance) {
    return new LateInitialized(instance);
  }
}
