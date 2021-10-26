package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class ReportHandler extends MappedObject {
  public ReportHandler() {
    this(new Object[0]);
  }

  public ReportHandler(Object instance) {
    super(Mappings.get("ReportHandler"), instance);
  }

  public ReportHandler(Object[] args) {
    super(Mappings.get("ReportHandler"), args);
  }

  public Object apply(Object arg0) {
    return (Object) call("apply", arg0);
  }

  public static ReportHandler wrap(Object instance) {
    return new ReportHandler(instance);
  }
}
