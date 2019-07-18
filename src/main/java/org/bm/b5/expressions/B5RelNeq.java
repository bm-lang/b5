package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5RelNeq extends B5Rel0 {

  public B5RelNeq(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr, left, right);
  }
}