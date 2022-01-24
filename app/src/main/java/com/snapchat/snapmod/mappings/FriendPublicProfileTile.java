package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;

public class FriendPublicProfileTile extends MappedObject {
  public FriendPublicProfileTile(long arg0, Object arg1, Object arg2, Object arg3, Long arg4,
      Object arg5, Object arg6) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5, arg6 });
  }

  public FriendPublicProfileTile() {
    this(new Object[0]);
  }

  public FriendPublicProfileTile(Object instance) {
    super(Mappings.get("FriendPublicProfileTile"), instance);
  }

  public FriendPublicProfileTile(Object[] args) {
    super(Mappings.get("FriendPublicProfileTile"), args);
  }

  public String getProfilePictureUrl() {
    return (java.lang.String) get("profilePictureUrl");
  }

  public void setProfilePictureUrl(String value) {
    set("profilePictureUrl", value);
  }

  public static FriendPublicProfileTile wrap(Object instance) {
    return new FriendPublicProfileTile(instance);
  }
}
