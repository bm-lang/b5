package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5Ref;

public class B5Set extends B5Instr {

  public B5Ref ref;
  public B5Expr value;

  public B5Set(B5Block parent) {
    super(parent);
  }

  @Override
  public void check() {

  }
}
