package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5UnaryOperation extends B5Expr {

  public final B5UnaryOperator operator;
  public final B5Expr value;

  public B5UnaryOperation(B5Instr instr, B5UnaryOperator operator, B5Expr value) {
    super(instr);
    this.operator = operator;
    this.value = value;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void resolve() {
    value.resolve();
  }

}
