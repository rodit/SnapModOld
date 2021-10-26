package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class ReportStatusHandler extends MappedObject {
  public static int ERROR_CASE = 0;

  public ReportStatusHandler() {
    this(new Object[0]);
  }

  public ReportStatusHandler(Object instance) {
    super(Mappings.get("ReportStatusHandler"), instance);
  }

  public ReportStatusHandler(Object[] args) {
    super(Mappings.get("ReportStatusHandler"), args);
  }

  public Object invoke() {
    return (Object) call("invoke", new Object[0]);
  }

  public int getStatus() {
    return (int) get("status");
  }

  public void setStatus(int value) {
    set("status", value);
  }

  public static ReportStatusHandler wrap(Object instance) {
    return new ReportStatusHandler(instance);
  }
}
