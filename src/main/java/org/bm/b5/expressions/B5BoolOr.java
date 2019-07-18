package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5BoolOr extends B5Bool2 {

  public B5BoolOr(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr, left, right);
  }

}