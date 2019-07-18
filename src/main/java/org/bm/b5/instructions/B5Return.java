package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;
import org.bm.b5.expressions.B5Expr;

public class B5Return extends B5Instr {

  public B5Expr value;

  public B5Return(B5Block parent) {
    super(parent);
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void link() {
    value.resolve();
  }
}
