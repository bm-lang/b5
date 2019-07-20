package org.bm.b5.runtime.values;

import org.bm.b5.runtime.RValue;

public class RBool extends RPlain {

  private final boolean value;

  public RBool(boolean value) {
    this.value = value;
  }

  public boolean getValue() {
    return value;
  }
}
