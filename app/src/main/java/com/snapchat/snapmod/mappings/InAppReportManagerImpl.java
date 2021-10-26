package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class InAppReportManagerImpl extends MappedObject {
  public InAppReportManagerImpl(Object arg0, Object arg1, Object arg2, Object arg3, Object arg4,
      Object arg5, Object arg6) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6 });
  }

  public InAppReportManagerImpl() {
    this(new Object[0]);
  }

  public InAppReportManagerImpl(Object instance) {
    super(Mappings.get("InAppReportManagerImpl"), instance);
  }

  public InAppReportManagerImpl(Object[] args) {
    super(Mappings.get("InAppReportManagerImpl"), args);
  }

  public static InAppReportManagerImpl wrap(Object instance) {
    return new InAppReportManagerImpl(instance);
  }
}
