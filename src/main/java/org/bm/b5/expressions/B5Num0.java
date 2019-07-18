package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5Num0 extends B5Expr {

  public final B5Expr left;
  public final B5Expr right;

  public B5Num0(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr);
    this.left = left;
    this.right = right;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public B5Type findType() {
    B5Type leftType = left.findType();
    B5Type rightType = right.findType();
    return instr.getProgram().findBiggestNumberType(leftType, rightType);
  }

  @Override
  public void resolveReferences() {
    left.resolveReferences();
    right.resolveReferences();
  }

}