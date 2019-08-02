package org.bm.b5.runtime.values;

import org.bm.b5.B5Exception;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.runtime.RMachine;
import org.bm.b5.runtime.RScope;

public class RInt32 extends RNumber {

  private final RScope scope;
  private final B5Type type;
  private final int value;

  public RInt32(RScope scope, int value) {
    this.scope = scope;
    this.value = value;
    this.type = scope.getMachine().getProgram().typeInt32;
  }

  public int getValue() {
    return value;
  }

  @Override
  public B5Type getType() {
    return type;
  }

  @Override
  public RNumber addition(RNumber number) {
    if (number instanceof RInt32) {
      return new RInt32(scope, ((RInt32)number).value + this.value);
    }
    else {
      throw new B5Exception("not number");
    }
  }
}
