package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Literal extends B5Expr {

  public final String value;
  public final B5Type type;

  public B5Literal(B5Scope scope, String value, B5Type type) {
    super(scope);
    this.value = value;
    this.type = type;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    // TODO
  }

  @Override
  public B5Type findType() {
    if (!type.isNative) {
      throw new B5Exception("literals can only be native: " + type);
    }
    return type;
  }

  @Override
  public void resolveReferences() {

  }
}
