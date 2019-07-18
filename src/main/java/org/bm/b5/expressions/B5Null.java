package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5Null extends B5Expr {

  public B5Null(B5Instr instr) {
    super(instr);
  }

  @Override
  public B5Type findType() {
    return instr.getProgram().typeAny;
  }

  @Override
  public void resolveReferences() {

  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

  }
}
