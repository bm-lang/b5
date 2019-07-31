package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Rel0 extends B5Expr {

  public final B5Expr left;
  public final B5Expr right;

  public B5Rel0(B5Scope scope, B5Expr left, B5Expr right) {
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

    if (!scope.getProgram().isNumberType(leftType)) {
      throw new B5Exception("expected " + leftType + " to be number");
    }
    else if (!scope.getProgram().isNumberType(rightType)) {
      throw new B5Exception("expected " + rightType + " to be number");
    }

    setResultingType(scope.getProgram().typeBool);
  }


}