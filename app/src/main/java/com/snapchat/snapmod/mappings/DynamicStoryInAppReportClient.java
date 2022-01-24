package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class DynamicStoryInAppReportClient extends MappedObject {
  public DynamicStoryInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3) {
    this(new Object[] { arg0, arg1, arg2, arg3 });
  }

  public DynamicStoryInAppReportClient() {
    this(new Object[0]);
  }

  public DynamicStoryInAppReportClient(Object instance) {
    super(Mappings.get("DynamicStoryInAppReportClient"), instance);
  }

  public DynamicStoryInAppReportClient(Object[] args) {
    super(Mappings.get("DynamicStoryInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static DynamicStoryInAppReportClient wrap(Object instance) {
    return new DynamicStoryInAppReportClient(instance);
  }
}
