package org.bm.b5.expressions;

import org.bm.b5.B5Element;
import org.bm.b5.instructions.B5Instr;

abstract public class B5Expr extends B5Element {

  abstract public void resolve(); // TODO should this be inherited from B5Scope?

  public final B5Instr instr;

  public B5Expr(B5Instr instr) {
    this.instr = instr;
  }

}
