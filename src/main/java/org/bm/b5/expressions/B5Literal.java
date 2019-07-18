package org.bm.b5.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5Literal extends B5Expr {

  public final String value;
  public final B5Type type;

  public B5Literal(B5Instr instr, String value, B5Type type) {
    super(instr);
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
