package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class PublisherStoryInAppReportClient extends MappedObject {
  public PublisherStoryInAppReportClient(Object arg0, Object arg1, Object arg2, Object arg3) {
    this(new Object[] { arg0, arg1, arg2, arg3 });
  }

  public PublisherStoryInAppReportClient() {
    this(new Object[0]);
  }

  public PublisherStoryInAppReportClient(Object instance) {
    super(Mappings.get("PublisherStoryInAppReportClient"), instance);
  }

  public PublisherStoryInAppReportClient(Object[] args) {
    super(Mappings.get("PublisherStoryInAppReportClient"), args);
  }

  public Object report(StoryMedia arg0, Object arg1) {
    return (Object) call("report", arg0, arg1);
  }

  public static PublisherStoryInAppReportClient wrap(Object instance) {
    return new PublisherStoryInAppReportClient(instance);
  }
}
