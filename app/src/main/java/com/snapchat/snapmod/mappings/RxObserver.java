package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.Throwable;

public class RxObserver extends MappedObject {
  public RxObserver() {
    this(new Object[0]);
  }

  public RxObserver(Object instance) {
    super(Mappings.get("RxObserver"), instance);
  }

  public RxObserver(Object[] args) {
    super(Mappings.get("RxObserver"), args);
  }

  public void disposable(Object arg0) {
    call("disposable", arg0);
  }

  public void accept(Object arg0) {
    call("accept", arg0);
  }

  public void error(Throwable arg0) {
    call("error", arg0);
  }

  public static RxObserver wrap(Object instance) {
    return new RxObserver(instance);
  }
}
