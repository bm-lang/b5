package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Null extends B5Expr {

  public B5Null(B5Scope scope) {
    super(scope);
  }

  @Override
  public B5Type findType() {
    return scope.getProgram().typeAny;
  }

  @Override
  public void resolveReferences() {

  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

  }
}
