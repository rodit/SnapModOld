package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class FriendStoryInAppReportClientImpl extends MappedObject {
  public FriendStoryInAppReportClientImpl(Object arg0, Object arg1, Object arg2, Object arg3,
      Object arg4) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4 });
  }

  public FriendStoryInAppReportClientImpl() {
    this(new Object[0]);
  }

  public FriendStoryInAppReportClientImpl(Object instance) {
    super(Mappings.get("FriendStoryInAppReportClientImpl"), instance);
  }

  public FriendStoryInAppReportClientImpl(Object[] args) {
    super(Mappings.get("FriendStoryInAppReportClientImpl"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static FriendStoryInAppReportClientImpl wrap(Object instance) {
    return new FriendStoryInAppReportClientImpl(instance);
  }
}
