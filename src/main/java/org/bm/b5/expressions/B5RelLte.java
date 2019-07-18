package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5RelLte extends B5Rel0 {

  public B5RelLte(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr, left, right);
  }

}