package org.bm.b5.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5Bool2 extends B5Expr {

  public final B5Expr left;
  public final B5Expr right;

  public B5Bool2(B5Instr instr, B5Expr left, B5Expr right) {
    super(instr);
    this.left = left;
    this.right = right;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    left.checkTypes();
    right.checkTypes();

    B5Type leftType = left.findType();
    B5Type rightType = right.findType();

    if (leftType != instr.getProgram().typeBool) {
      throw new B5Exception("expected " + leftType + " to be bool");
    }
    else if (rightType != instr.getProgram().typeBool) {
      throw new B5Exception("expected " + rightType + " to be bool");
    }
  }

  @Override
  public B5Type findType() {
    return instr.getProgram().typeBool;
  }

  @Override
  public void resolveReferences() {
    left.resolveReferences();
    right.resolveReferences();
  }

}