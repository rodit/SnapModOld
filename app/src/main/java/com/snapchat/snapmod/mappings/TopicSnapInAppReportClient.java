package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class TopicSnapInAppReportClient extends MappedObject {
  public TopicSnapInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3) {
    this(new Object[] { arg0, arg1, arg2, arg3 });
  }

  public TopicSnapInAppReportClient() {
    this(new Object[0]);
  }

  public TopicSnapInAppReportClient(Object instance) {
    super(Mappings.get("TopicSnapInAppReportClient"), instance);
  }

  public TopicSnapInAppReportClient(Object[] args) {
    super(Mappings.get("TopicSnapInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static TopicSnapInAppReportClient wrap(Object instance) {
    return new TopicSnapInAppReportClient(instance);
  }
}
