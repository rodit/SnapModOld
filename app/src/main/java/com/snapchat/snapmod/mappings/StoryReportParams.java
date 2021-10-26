package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class StoryReportParams extends MappedObject {
  public StoryReportParams() {
    this(new Object[0]);
  }

  public StoryReportParams(Object instance) {
    super(Mappings.get("StoryReportParams"), instance);
  }

  public StoryReportParams(Object[] args) {
    super(Mappings.get("StoryReportParams"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public String getSnapId() {
    return (java.lang.String) get("snapId");
  }

  public void setSnapId(String value) {
    set("snapId", value);
  }

  public OperaMediaInfo getMediaInfo() {
    return OperaMediaInfo.wrap(get("mediaInfo"));
  }

  public void setMediaInfo(OperaMediaInfo value) {
    set("mediaInfo", value);
  }

  public static StoryReportParams wrap(Object instance) {
    return new StoryReportParams(instance);
  }
}
