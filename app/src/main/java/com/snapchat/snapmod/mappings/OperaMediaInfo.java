package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Object;
import java.lang.String;

public class OperaMediaInfo extends MappedObject {
  public OperaMediaInfo() {
    this(new Object[0]);
  }

  public OperaMediaInfo(Object instance) {
    super(Mappings.get("OperaMediaInfo"), instance);
  }

  public OperaMediaInfo(Object[] args) {
    super(Mappings.get("OperaMediaInfo"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public StreamingMethod getStreamingMethod() {
    return StreamingMethod.wrap(get("streamingMethod"));
  }

  public void setStreamingMethod(StreamingMethod value) {
    set("streamingMethod", value);
  }

  public EncryptionAlgorithm getEncryption() {
    return EncryptionAlgorithm.wrap(get("encryption"));
  }

  public void setEncryption(EncryptionAlgorithm value) {
    set("encryption", value);
  }

  public String getUri() {
    return (java.lang.String) get("uri");
  }

  public void setUri(String value) {
    set("uri", value);
  }

  public static OperaMediaInfo wrap(Object instance) {
    return new OperaMediaInfo(instance);
  }
}
