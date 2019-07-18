package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5BitNot extends B5Expr {

  public final B5Expr value;

  public B5BitNot(B5Instr instr, B5Expr value) {
    super(instr);
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
}
