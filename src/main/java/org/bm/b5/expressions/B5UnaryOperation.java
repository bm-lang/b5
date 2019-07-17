package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5UnaryOperation extends B5Expr {

  public final B5UnaryOperator operator;
  public final B5Expr value;

  public B5UnaryOperation(B5Instr parent, B5UnaryOperator operator, B5Expr value) {
    super(parent);
    this.operator = operator;
    this.value = value;
  }

  @Override
  public void check() {

  }

}
