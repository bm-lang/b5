package org.bm.b5;

public class B5Exception extends RuntimeException {

  public B5Exception(Throwable cause, String message) {
    super(message, cause);
  }

  public B5Exception(String message) {
    super(message);
  }

}
