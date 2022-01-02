package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class LocationMessage extends MappedObject {
  public LocationMessage() {
    this(new Object[0]);
  }

  public LocationMessage(Object instance) {
    super(Mappings.get("LocationMessage"), instance);
  }

  public LocationMessage(Object[] args) {
    super(Mappings.get("LocationMessage"), args);
  }

  public double getLongitude() {
    return (double) get("longitude");
  }

  public void setLongitude(double value) {
    set("longitude", value);
  }

  public double getLatitude() {
    return (double) get("latitude");
  }

  public void setLatitude(double value) {
    set("latitude", value);
  }

  public static LocationMessage wrap(Object instance) {
    return new LocationMessage(instance);
  }
}
