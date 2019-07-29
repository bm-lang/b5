package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Instr;

public class B5RelGte extends B5Rel0 {

  public B5RelGte(B5Scope scope, B5Expr left, B5Expr right) {
    super(scope, left, right);
  }

}