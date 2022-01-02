package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class FriendActionRequest extends MappedObject {
  public FriendActionRequest() {
    this(new Object[0]);
  }

  public FriendActionRequest(Object instance) {
    super(Mappings.get("FriendActionRequest"), instance);
  }

  public FriendActionRequest(Object[] args) {
    super(Mappings.get("FriendActionRequest"), args);
  }

  public String getAddedBy() {
    return (java.lang.String) get("addedBy");
  }

  public void setAddedBy(String value) {
    set("addedBy", value);
  }

  public String getAction() {
    return (java.lang.String) get("action");
  }

  public void setAction(String value) {
    set("action", value);
  }

  public static FriendActionRequest wrap(Object instance) {
    return new FriendActionRequest(instance);
  }
}
