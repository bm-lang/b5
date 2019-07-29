package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5New extends B5Expr {

  public final B5Type type;

  public B5New(B5Scope scope, B5Type type) {
    super(scope);
    this.type = type;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

  }

  @Override
  public B5Type findType() {
    return type;
  }

  @Override
  public void resolveReferences() {

  }

}
