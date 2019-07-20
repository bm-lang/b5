package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Element;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

abstract public class B5Expr extends B5Element {

  abstract public B5Type findType();

  abstract public void resolveReferences(); // TODO should this be inherited from B5Scope?

  public final B5Instr instr;

  public B5Expr(B5Instr instr) {
    this.instr = instr;
  }

  public B5Program getProgram() {
    return instr.getProgram();
  }

}
