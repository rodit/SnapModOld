package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;
import java.util.concurrent.TimeUnit;

public class MemoriesPickerVideoDurationConfig extends MappedObject {
  public MemoriesPickerVideoDurationConfig() {
    this(new Object[0]);
  }

  public MemoriesPickerVideoDurationConfig(Object instance) {
    super(Mappings.get("MemoriesPickerVideoDurationConfig"), instance);
  }

  public MemoriesPickerVideoDurationConfig(Object[] args) {
    super(Mappings.get("MemoriesPickerVideoDurationConfig"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public TimeUnit getTimeUnit() {
    return (java.util.concurrent.TimeUnit) get("timeUnit");
  }

  public void setTimeUnit(TimeUnit value) {
    set("timeUnit", value);
  }

  public long getMaxDuration() {
    return (long) get("maxDuration");
  }

  public void setMaxDuration(long value) {
    set("maxDuration", value);
  }

  public int getWarningTextResource() {
    return (int) get("warningTextResource");
  }

  public void setWarningTextResource(int value) {
    set("warningTextResource", value);
  }

  public static MemoriesPickerVideoDurationConfig wrap(Object instance) {
    return new MemoriesPickerVideoDurationConfig(instance);
  }
}
