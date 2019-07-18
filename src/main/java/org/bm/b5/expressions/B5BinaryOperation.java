package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5BinaryOperation extends B5Expr {

  public final B5BinaryOperator operator;
  public final B5Expr left;
  public final B5Expr right;

  public B5BinaryOperation(B5Instr instr, B5BinaryOperator operator, B5Expr left, B5Expr right) {
    super(instr);
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void resolveReferences() {
    left.resolveReferences();
    right.resolveReferences();
  }

}
