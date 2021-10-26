package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class StreamingMethod extends MappedObject {
  public StreamingMethod() {
    this(new Object[0]);
  }

  public StreamingMethod(Object instance) {
    super(Mappings.get("StreamingMethod"), instance);
  }

  public StreamingMethod(Object[] args) {
    super(Mappings.get("StreamingMethod"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public static StreamingMethod wrap(Object instance) {
    return new StreamingMethod(instance);
  }
}
