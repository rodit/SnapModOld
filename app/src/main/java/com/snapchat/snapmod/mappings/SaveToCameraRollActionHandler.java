package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class SaveToCameraRollActionHandler extends MappedObject {
  public SaveToCameraRollActionHandler(Object arg0, Object arg1, Object arg2, Object arg3,
      Object arg4, Object arg5) {
    this(new Object[] { arg0, arg1, arg2, arg3, arg4, arg5 });
  }

  public SaveToCameraRollActionHandler() {
    this(new Object[0]);
  }

  public SaveToCameraRollActionHandler(Object instance) {
    super(Mappings.get("SaveToCameraRollActionHandler"), instance);
  }

  public SaveToCameraRollActionHandler(Object[] args) {
    super(Mappings.get("SaveToCameraRollActionHandler"), args);
  }

  public void exportMedia(Object arg0, ChatModelBase arg1, SaveType arg2) {
    call("exportMedia", arg0, arg1, arg2);
  }

  public static SaveToCameraRollActionHandler wrap(Object instance) {
    return new SaveToCameraRollActionHandler(instance);
  }
}
