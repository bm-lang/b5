package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5Len extends B5Expr {

  public final B5Expr array;

  public B5Len(B5Instr instr, B5Expr array) {
    super(instr);
    this.array = array;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public B5Type findType() {
    return instr.getProgram().typeInt32;
  }

  @Override
  public void resolveReferences() {
    array.resolveReferences();
  }

}
