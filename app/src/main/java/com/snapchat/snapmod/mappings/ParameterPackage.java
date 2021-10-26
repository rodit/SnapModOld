package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Object;
import java.lang.String;

public class ParameterPackage extends MappedObject {
  public ParameterPackage(String arg0, String arg1) {
    this(new Object[] { arg0, arg1 });
  }

  public ParameterPackage(Boolean arg0, Double arg1, String arg2, String arg3, Object arg4,
      String arg5, Object arg6, String arg7, String arg8, Object arg9, String arg10, String arg11,
      Boolean arg12) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12 });
  }

  public ParameterPackage() {
    this(new Object[0]);
  }

  public ParameterPackage(Object instance) {
    super(Mappings.get("ParameterPackage"), instance);
  }

  public ParameterPackage(Object[] args) {
    super(Mappings.get("ParameterPackage"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public Boolean getIsInfiniteDuration() {
    return (java.lang.Boolean) get("isInfiniteDuration");
  }

  public void setIsInfiniteDuration(Boolean value) {
    set("isInfiniteDuration", value);
  }

  public Double getTimerOrDurationSeconds() {
    return (java.lang.Double) get("timerOrDurationSeconds");
  }

  public void setTimerOrDurationSeconds(Double value) {
    set("timerOrDurationSeconds", value);
  }

  public static ParameterPackage wrap(Object instance) {
    return new ParameterPackage(instance);
  }
}
