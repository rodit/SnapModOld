package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class PublicUserStoryInAppReportClient extends MappedObject {
  public PublicUserStoryInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3) {
    this(new Object[] { arg0, arg1, arg2, arg3 });
  }

  public PublicUserStoryInAppReportClient() {
    this(new Object[0]);
  }

  public PublicUserStoryInAppReportClient(Object instance) {
    super(Mappings.get("PublicUserStoryInAppReportClient"), instance);
  }

  public PublicUserStoryInAppReportClient(Object[] args) {
    super(Mappings.get("PublicUserStoryInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static PublicUserStoryInAppReportClient wrap(Object instance) {
    return new PublicUserStoryInAppReportClient(instance);
  }
}
