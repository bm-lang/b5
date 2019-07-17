package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5Array extends B5Expr {

  public final B5Expr size;

  public B5Array(B5Instr parent, B5Expr size) {
    super(parent);
    this.size = size;
  }

  @Override
  public void check() {

  }

}
