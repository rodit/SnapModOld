package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class DirectSnapInAppReportClient extends MappedObject {
  public DirectSnapInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3,
      Object arg4, Object arg5) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5 });
  }

  public DirectSnapInAppReportClient() {
    this(new Object[0]);
  }

  public DirectSnapInAppReportClient(Object instance) {
    super(Mappings.get("DirectSnapInAppReportClient"), instance);
  }

  public DirectSnapInAppReportClient(Object[] args) {
    super(Mappings.get("DirectSnapInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static DirectSnapInAppReportClient wrap(Object instance) {
    return new DirectSnapInAppReportClient(instance);
  }
}
