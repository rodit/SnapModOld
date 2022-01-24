package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class PublicProfileInfo extends MappedObject {
  public PublicProfileInfo() {
    this(new Object[0]);
  }

  public PublicProfileInfo(Object instance) {
    super(Mappings.get("PublicProfileInfo"), instance);
  }

  public PublicProfileInfo(Object[] args) {
    super(Mappings.get("PublicProfileInfo"), args);
  }

  public String getId() {
    return (String) call("getId", new Object[0]);
  }

  public String getTitle() {
    return (String) call("getTitle", new Object[0]);
  }

  public String getProfilePictureUrl() {
    return (String) call("getProfilePictureUrl", new Object[0]);
  }

  public static PublicProfileInfo wrap(Object instance) {
    return new PublicProfileInfo(instance);
  }
}
