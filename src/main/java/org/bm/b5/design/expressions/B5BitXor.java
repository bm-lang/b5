package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Instr;

public class B5BitXor extends B5Bit2 {

  public B5BitXor(B5Scope scope, B5Expr left, B5Expr right) {
    super(scope, left, right);
  }

}