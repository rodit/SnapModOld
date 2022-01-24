package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class FriendStoryInAppReportClient extends MappedObject {
  public FriendStoryInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3,
      Object arg4) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4 });
  }

  public FriendStoryInAppReportClient() {
    this(new Object[0]);
  }

  public FriendStoryInAppReportClient(Object instance) {
    super(Mappings.get("FriendStoryInAppReportClient"), instance);
  }

  public FriendStoryInAppReportClient(Object[] args) {
    super(Mappings.get("FriendStoryInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static FriendStoryInAppReportClient wrap(Object instance) {
    return new FriendStoryInAppReportClient(instance);
  }
}
