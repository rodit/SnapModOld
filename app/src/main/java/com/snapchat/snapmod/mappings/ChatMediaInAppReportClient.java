package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class ChatMediaInAppReportClient extends MappedObject {
  public ChatMediaInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3,
      Object arg4) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4 });
  }

  public ChatMediaInAppReportClient() {
    this(new Object[0]);
  }

  public ChatMediaInAppReportClient(Object instance) {
    super(Mappings.get("ChatMediaInAppReportClient"), instance);
  }

  public ChatMediaInAppReportClient(Object[] args) {
    super(Mappings.get("ChatMediaInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static ChatMediaInAppReportClient wrap(Object instance) {
    return new ChatMediaInAppReportClient(instance);
  }
}
