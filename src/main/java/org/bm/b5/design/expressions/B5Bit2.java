package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

abstract public class B5Bit2 extends B5Expr {

  public final B5Expr left;
  public final B5Expr right;

  public B5Bit2(B5Scope scope, B5Expr left, B5Expr right) {
    super(scope);
    this.left = left;
    this.right = right;
  }

  @Override
  public void link() {
    left.link();
    right.link();
  }

  @Override
  public void compile() {
    left.compile();
    right.compile();

    B5Type leftType = left.getResultingType();
    B5Type rightType = right.getResultingType();

    if (!scope.getProgram().isIntegerType(leftType)) {
      throw new B5Exception("expected " + leftType + " to be integer");
    }
    else if (!scope.getProgram().isIntegerType(rightType)) {
      throw new B5Exception("expected " + rightType + " to be integer");
    }

    B5Type resultingType = scope.getProgram().findBiggestIntegerType(leftType, rightType);

    setResultingType(resultingType);
  }

}