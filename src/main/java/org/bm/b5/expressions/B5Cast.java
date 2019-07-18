package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5Cast extends B5Expr {

  public final B5Expr value;
  public final B5Type type;

  public B5Cast(B5Instr instr, B5Expr value, B5Type type) {
    super(instr);
    this.value = value;
    this.type = type;
  }

  @Override
  public B5Type findType() {
    return type;
  }

  @Override
  public void resolveReferences() {
    value.resolveReferences();
  }

  @Override
  public void checkDefinition() {
    value.checkDefinition();
    type.checkDefinition();
  }

  @Override
  public void checkTypes() {
    value.checkTypes();

    // TODO detect impossible casts
  }
}
