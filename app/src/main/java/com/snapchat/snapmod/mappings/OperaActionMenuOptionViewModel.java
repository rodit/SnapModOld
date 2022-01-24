package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class OperaActionMenuOptionViewModel extends MappedObject {
  public OperaActionMenuOptionViewModel() {
    this(new Object[0]);
  }

  public OperaActionMenuOptionViewModel(Object instance) {
    super(Mappings.get("OperaActionMenuOptionViewModel"), instance);
  }

  public OperaActionMenuOptionViewModel(Object[] args) {
    super(Mappings.get("OperaActionMenuOptionViewModel"), args);
  }

  public Object getActionMenuId() {
    return (Object) get("actionMenuId");
  }

  public void setActionMenuId(Object value) {
    set("actionMenuId", value);
  }

  public int getIconResource() {
    return (int) get("iconResource");
  }

  public void setIconResource(int value) {
    set("iconResource", value);
  }

  public boolean getLoading() {
    return (boolean) get("loading");
  }

  public void setLoading(boolean value) {
    set("loading", value);
  }

  public int getTextColorResource() {
    return (int) get("textColorResource");
  }

  public void setTextColorResource(int value) {
    set("textColorResource", value);
  }

  public int getStringResource() {
    return (int) get("stringResource");
  }

  public void setStringResource(int value) {
    set("stringResource", value);
  }

  public String getEventName() {
    return (java.lang.String) get("eventName");
  }

  public void setEventName(String value) {
    set("eventName", value);
  }

  public static OperaActionMenuOptionViewModel wrap(Object instance) {
    return new OperaActionMenuOptionViewModel(instance);
  }
}
