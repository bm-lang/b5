package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Array extends B5Expr {

  public final B5Expr size;

  public B5Array(B5Scope scope, B5Expr size) {
    super(scope);
    this.size = size;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    size.checkTypes();
  }

  @Override
  public B5Type findType() {
    return scope.getProgram().typeArray;
  }

  @Override
  public void resolveReferences() {
    size.resolveReferences();
  }

}
