package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class OperaContextActions extends MappedObject {
  public static String REPORT_EVENT_NAME = "IN_APP_REPORT";

  public static String SAVE_EVENT_NAME = "SAVE";

  public OperaContextActions() {
    this(new Object[0]);
  }

  public OperaContextActions(Object instance) {
    super(Mappings.get("OperaContextActions"), instance);
  }

  public OperaContextActions(Object[] args) {
    super(Mappings.get("OperaContextActions"), args);
  }

  public static OperaContextActions wrap(Object instance) {
    return new OperaContextActions(instance);
  }
}
