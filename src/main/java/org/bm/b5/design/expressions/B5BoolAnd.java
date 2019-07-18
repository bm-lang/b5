package org.bm.b5.design.expressions;

import org.bm.b5.design.instructions.B5Instr;

public class B5BoolAnd extends B5Bool2 {

  public B5BoolAnd(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr, left, right);
  }

}