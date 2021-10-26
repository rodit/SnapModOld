package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class RxSupplier extends MappedObject {
  public RxSupplier() {
    this(new Object[0]);
  }

  public RxSupplier(Object instance) {
    super(Mappings.get("RxSupplier"), instance);
  }

  public RxSupplier(Object[] args) {
    super(Mappings.get("RxSupplier"), args);
  }

  public void subscribe(RxObserver arg0) {
    call("subscribe", arg0);
  }

  public static RxSupplier wrap(Object instance) {
    return new RxSupplier(instance);
  }
}
