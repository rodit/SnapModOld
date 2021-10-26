package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class GlobalErrorHandler extends MappedObject {
  public static int REPORT_ERROR_CASE = 182;

  public GlobalErrorHandler() {
    this(new Object[0]);
  }

  public GlobalErrorHandler(Object instance) {
    super(Mappings.get("GlobalErrorHandler"), instance);
  }

  public GlobalErrorHandler(Object[] args) {
    super(Mappings.get("GlobalErrorHandler"), args);
  }

  public void accept(Object arg0) {
    call("accept", arg0);
  }

  public int getErrorCode() {
    return (int) get("errorCode");
  }

  public void setErrorCode(int value) {
    set("errorCode", value);
  }

  public static GlobalErrorHandler wrap(Object instance) {
    return new GlobalErrorHandler(instance);
  }
}
