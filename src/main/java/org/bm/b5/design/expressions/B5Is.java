package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Is extends B5Expr {

  public final B5Expr value;

  public final B5Type type;

  public B5Is(B5Scope scope, B5Expr value, B5Type type) {
    super(scope);
    this.value = value;
    this.type = type;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    value.checkTypes();
    // TODO check for impossible comparisons
  }

  @Override
  public B5Type findType() {
    return scope.getProgram().typeBool;
  }

  @Override
  public void resolveReferences() {
    value.resolveReferences();
  }

}
