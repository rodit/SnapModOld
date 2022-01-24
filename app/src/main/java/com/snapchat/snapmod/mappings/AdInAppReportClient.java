package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class AdInAppReportClient extends MappedObject {
  public AdInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3) {
    this(new Object[] { arg0, arg1, arg2, arg3 });
  }

  public AdInAppReportClient() {
    this(new Object[0]);
  }

  public AdInAppReportClient(Object instance) {
    super(Mappings.get("AdInAppReportClient"), instance);
  }

  public AdInAppReportClient(Object[] args) {
    super(Mappings.get("AdInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static AdInAppReportClient wrap(Object instance) {
    return new AdInAppReportClient(instance);
  }
}
