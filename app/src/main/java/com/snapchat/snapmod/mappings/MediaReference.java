package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class MediaReference extends MappedObject {
  public MediaReference() {
    this(new Object[0]);
  }

  public MediaReference(Object instance) {
    super(Mappings.get("MediaReference"), instance);
  }

  public MediaReference(Object[] args) {
    super(Mappings.get("MediaReference"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public Object getUri() {
    return (Object) get("uri");
  }

  public void setUri(Object value) {
    set("uri", value);
  }

  public Object getType() {
    return (Object) get("type");
  }

  public void setType(Object value) {
    set("type", value);
  }

  public static MediaReference wrap(Object instance) {
    return new MediaReference(instance);
  }
}
