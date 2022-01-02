package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class QuotedMessageViewModel extends MappedObject {
  public QuotedMessageViewModel() {
    this(new Object[0]);
  }

  public QuotedMessageViewModel(Object instance) {
    super(Mappings.get("QuotedMessageViewModel"), instance);
  }

  public QuotedMessageViewModel(Object[] args) {
    super(Mappings.get("QuotedMessageViewModel"), args);
  }

  public static QuotedMessageViewModel wrap(Object instance) {
    return new QuotedMessageViewModel(instance);
  }
}
