package org.bm.b5.runtime.values;

public class RInt32 extends RPlain {

  private final int value;

  public RInt32(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

}
