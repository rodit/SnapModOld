package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class Metrics extends MappedObject {
  public Metrics() {
    this(new Object[0]);
  }

  public Metrics(Object instance) {
    super(Mappings.get("Metrics"), instance);
  }

  public Metrics(Object[] args) {
    super(Mappings.get("Metrics"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public static Metrics wrap(Object instance) {
    return new Metrics(instance);
  }
}
