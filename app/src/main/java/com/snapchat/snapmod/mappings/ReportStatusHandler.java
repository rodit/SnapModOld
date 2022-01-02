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

  public static ReportStatusHandler wrap(Object instance) {
    return new ReportStatusHandler(instance);
  }
}
