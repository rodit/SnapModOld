package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;
import java.util.Map;

public class LocationMessageBuilder extends MappedObject {
  public LocationMessageBuilder() {
    this(new Object[0]);
  }

  public LocationMessageBuilder(Object instance) {
    super(Mappings.get("LocationMessageBuilder"), instance);
  }

  public LocationMessageBuilder(Object[] args) {
    super(Mappings.get("LocationMessageBuilder"), args);
  }

  public RxSupplier transform(Object arg0, Object arg1, MediaReference arg2) {
    return RxSupplier.wrap(call("transform", arg0, arg1, arg2));
  }

  public Object build(Object arg0, String arg1, Object arg2, Map arg3) {
    return (Object) call("build", arg0, arg1, arg2, arg3);
  }

  public static LocationMessageBuilder wrap(Object instance) {
    return new LocationMessageBuilder(instance);
  }
}
