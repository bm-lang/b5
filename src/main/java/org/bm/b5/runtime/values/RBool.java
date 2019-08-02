package org.bm.b5.runtime.values;

import org.bm.b5.design.entities.B5Type;
import org.bm.b5.runtime.RMachine;
import org.bm.b5.runtime.RScope;
import org.bm.b5.runtime.RValue;

public class RBool extends RPlain {

  private final B5Type type;
  private final boolean value;

  public RBool(RScope scope, boolean value) {
    this.type = scope.getMachine().getProgram().typeBool;
    this.value = value;
  }

  public boolean getValue() {
    return value;
  }

  @Override
  public B5Type getType() {
    return type;
  }
}
