package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class PublicUserReportParams extends MappedObject {
  public PublicUserReportParams() {
    this(new Object[0]);
  }

  public PublicUserReportParams(Object instance) {
    super(Mappings.get("PublicUserReportParams"), instance);
  }

  public PublicUserReportParams(Object[] args) {
    super(Mappings.get("PublicUserReportParams"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public String getUserId() {
    return (java.lang.String) get("userId");
  }

  public void setUserId(String value) {
    set("userId", value);
  }

  public String getUsername() {
    return (java.lang.String) get("username");
  }

  public void setUsername(String value) {
    set("username", value);
  }

  public static PublicUserReportParams wrap(Object instance) {
    return new PublicUserReportParams(instance);
  }
}
