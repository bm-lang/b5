package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Get extends B5Expr {

  public final B5Expr array;
  public final B5Expr index;

  public B5Get(B5Scope scope, B5Expr array, B5Expr index) {
    super(scope);
    this.array = array;
    this.index = index;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    array.checkTypes();
    index.checkTypes();
  }

  @Override
  public B5Type findType() {
    // since it comes from an array, it can be anything
    return scope.getProgram().typeAny;
  }

  @Override
  public void resolveReferences() {
    array.resolveReferences();
    index.resolveReferences();
  }

}
