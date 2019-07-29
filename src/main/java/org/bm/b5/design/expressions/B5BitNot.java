package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5BitNot extends B5Expr {

  public final B5Expr value;

  public B5BitNot(B5Scope scope, B5Expr value) {
    super(scope);
    this.value = value;
  }

  @Override
  public B5Type findType() {
    return value.findType();
  }

  @Override
  public void resolveReferences() {

  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    value.checkTypes();

    B5Type type = value.findType();

    if (!scope.getProgram().isIntegerType(type)) {
      throw new B5Exception("expected " + type + " to be integer");
    }
  }
}
