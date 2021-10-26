package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class FooterInfoItem extends MappedObject {
  public FooterInfoItem(String arg0, long arg1) {
    this(new Object[] { arg0, arg1 });
  }

  public FooterInfoItem() {
    this(new Object[0]);
  }

  public FooterInfoItem(Object instance) {
    super(Mappings.get("FooterInfoItem"), instance);
  }

  public FooterInfoItem(Object[] args) {
    super(Mappings.get("FooterInfoItem"), args);
  }

  public String getText() {
    return (java.lang.String) get("text");
  }

  public void setText(String value) {
    set("text", value);
  }

  public static FooterInfoItem wrap(Object instance) {
    return new FooterInfoItem(instance);
  }
}
