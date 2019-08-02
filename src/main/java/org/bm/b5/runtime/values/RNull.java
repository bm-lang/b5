package org.bm.b5.runtime.values;

import org.bm.b5.design.entities.B5Type;
import org.bm.b5.runtime.RException;
import org.bm.b5.runtime.RMachine;
import org.bm.b5.runtime.RScope;
import org.bm.b5.runtime.RValue;

public class RNull extends RPlain {

  private final B5Type type;

  public RNull(RScope scope) {
    this.type = scope.getMachine().getProgram().typeAny;
  }

  @Override
  public B5Type getType() {
    return type;
  }
}