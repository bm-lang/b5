package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5BinaryOperation extends B5Expr {

  public final B5BinaryOperator operator;
  public final B5Expr left;
  public final B5Expr right;

  public B5BinaryOperation(B5Instr parent, B5BinaryOperator operator, B5Expr left, B5Expr right) {
    super(parent);
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  @Override
  public void check() {

  }

}
