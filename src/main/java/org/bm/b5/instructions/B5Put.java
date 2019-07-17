package org.bm.b5.instructions;

import org.bm.b5.B5Referenceable;
import org.bm.b5.collections.B5Block;
import org.bm.b5.expressions.B5Expr;

public class B5Put extends B5Instr {

  public B5Expr array;
  public B5Expr index;
  public B5Expr value;

  public B5Put(B5Block parent) {
    super(parent);
  }

  @Override
  public void check() {

  }
}
