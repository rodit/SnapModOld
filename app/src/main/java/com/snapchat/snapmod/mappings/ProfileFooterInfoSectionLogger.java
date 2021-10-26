package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;

public class ProfileFooterInfoSectionLogger extends MappedObject {
  public ProfileFooterInfoSectionLogger() {
    this(new Object[0]);
  }

  public ProfileFooterInfoSectionLogger(Object instance) {
    super(Mappings.get("ProfileFooterInfoSectionLogger"), instance);
  }

  public ProfileFooterInfoSectionLogger(Object[] args) {
    super(Mappings.get("ProfileFooterInfoSectionLogger"), args);
  }

  public static ProfileFooterInfoSectionLogger wrap(Object instance) {
    return new ProfileFooterInfoSectionLogger(instance);
  }
}
