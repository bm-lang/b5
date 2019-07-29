package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Len extends B5Expr {

  public final B5Expr array;

  public B5Len(B5Scope scope, B5Expr array) {
    super(scope);
    this.array = array;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    array.checkTypes();

    B5Type type = array.findType();

    if (!scope.getProgram().isArrayType(type)) {
      throw new B5Exception("expected array type instead of: " + type);
    }
  }

  @Override
  public B5Type findType() {
    return scope.getProgram().typeInt32;
  }

  @Override
  public void resolveReferences() {
    array.resolveReferences();
  }

}
