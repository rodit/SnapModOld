package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class MediaDownloadStatus extends MappedObject {
  public MediaDownloadStatus() {
    this(new Object[0]);
  }

  public MediaDownloadStatus(Object instance) {
    super(Mappings.get("MediaDownloadStatus"), instance);
  }

  public MediaDownloadStatus(Object[] args) {
    super(Mappings.get("MediaDownloadStatus"), args);
  }

  public static MediaDownloadStatus valueOf(String value) {
    return (MediaDownloadStatus) Mappings.getEnumValue("MediaDownloadStatus", value);
  }

  public static MediaDownloadStatus wrap(Object instance) {
    return new MediaDownloadStatus(instance);
  }
}
