package org.bm.b5.expressions;

import org.bm.b5.B5Element;
import org.bm.b5.instructions.B5Instr;

abstract public class B5Expr extends B5Element {

  public final B5Instr parent;

  public B5Expr(B5Instr parent) {
    this.parent = parent;
  }

}
