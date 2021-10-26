package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class FriendLinkType extends MappedObject {
  public FriendLinkType() {
    this(new Object[0]);
  }

  public FriendLinkType(Object instance) {
    super(Mappings.get("FriendLinkType"), instance);
  }

  public FriendLinkType(Object[] args) {
    super(Mappings.get("FriendLinkType"), args);
  }

  public static FriendLinkType valueOf(String value) {
    return (FriendLinkType) Mappings.getEnumValue("FriendLinkType", value);
  }

  public static FriendLinkType wrap(Object instance) {
    return new FriendLinkType(instance);
  }
}
