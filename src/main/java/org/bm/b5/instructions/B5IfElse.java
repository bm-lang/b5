package org.bm.b5.instructions;

import org.bm.b5.B5Element;
import org.bm.b5.B5Scope;
import org.bm.b5.collections.B5Block;
import org.bm.b5.expressions.B5Expr;

public class B5IfElse extends B5Instr implements B5Scope {

  public final B5Block thenBody;
  public final B5Block elseBody;

  public B5Expr condition;

  public B5IfElse(B5Block parent) {
    super(parent);
    this.thenBody = new B5Block(this);
    this.elseBody = new B5Block(this);
  }

  @Override
  public void check() {

  }

}
