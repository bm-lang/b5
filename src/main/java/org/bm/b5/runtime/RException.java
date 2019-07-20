package org.bm.b5.runtime;

import org.bm.b5.B5Exception;

public class RException extends B5Exception {
  public RException(String message) {
    super(message);
  }
  public RException(Throwable cause, String message) {
    super(cause, message);
  }
}
