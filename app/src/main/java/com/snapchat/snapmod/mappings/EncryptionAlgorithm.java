package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Object;

public class EncryptionAlgorithm extends MappedObject {
  public EncryptionAlgorithm() {
    this(new Object[0]);
  }

  public EncryptionAlgorithm(Object instance) {
    super(Mappings.get("EncryptionAlgorithm"), instance);
  }

  public EncryptionAlgorithm(Object[] args) {
    super(Mappings.get("EncryptionAlgorithm"), args);
  }

  public OutputStream encryptStream(OutputStream arg0) {
    return (OutputStream) call("encryptStream", arg0);
  }

  public InputStream decryptStream(InputStream arg0) {
    return (InputStream) call("decryptStream", arg0);
  }

  public static EncryptionAlgorithm wrap(Object instance) {
    return new EncryptionAlgorithm(instance);
  }
}
