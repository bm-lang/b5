package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5BoolNot extends B5Expr {

  public final B5Expr value;

  public B5BoolNot(B5Scope scope, B5Expr value) {
    super(scope);
    this.value = value;
  }

  @Override
  public void link() {
    value.link();
  }

  @Override
  public void compile() {
    value.compile();

    B5Type type = value.getResultingType();

    if (!scope.getProgram().isBoolType(type)) {
      throw new B5Exception("expected " + type + " to be bool");
    }

    setResultingType(scope.getProgram().typeBool);
  }
}
