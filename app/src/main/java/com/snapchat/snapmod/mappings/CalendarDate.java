package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class CalendarDate extends MappedObject {
  public CalendarDate(int arg0, int arg1) {
    this(new Object[] { arg0, arg1 });
  }

  public CalendarDate() {
    this(new Object[0]);
  }

  public CalendarDate(Object instance) {
    super(Mappings.get("CalendarDate"), instance);
  }

  public CalendarDate(Object[] args) {
    super(Mappings.get("CalendarDate"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public int getMonth() {
    return (int) get("month");
  }

  public void setMonth(int value) {
    set("month", value);
  }

  public int getDay() {
    return (int) get("day");
  }

  public void setDay(int value) {
    set("day", value);
  }

  public static CalendarDate wrap(Object instance) {
    return new CalendarDate(instance);
  }
}
