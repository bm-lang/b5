package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5BitXor extends B5Bit2 {

  public B5BitXor(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr, left, right);
  }

}