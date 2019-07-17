package org.bm.b5.expressions;

import org.bm.b5.B5Referenceable;
import org.bm.b5.instructions.B5Instr;

public class B5Get extends B5Expr {

  public final B5Expr array;
  public final B5Expr index;

  public B5Get(B5Instr parent, B5Expr array, B5Expr index) {
    super(parent);
    this.array = array;
    this.index = index;
  }

  @Override
  public void check() {

  }

}
