package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5BitAnd extends B5Bit2 {

  public B5BitAnd(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr, left, right);
  }

}