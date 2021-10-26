package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class FeatureMetadata extends MappedObject {
  public FeatureMetadata() {
    this(new Object[0]);
  }

  public FeatureMetadata(Object instance) {
    super(Mappings.get("FeatureMetadata"), instance);
  }

  public FeatureMetadata(Object[] args) {
    super(Mappings.get("FeatureMetadata"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public static FeatureMetadata wrap(Object instance) {
    return new FeatureMetadata(instance);
  }
}
