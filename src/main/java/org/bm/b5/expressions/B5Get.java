package org.bm.b5.expressions;

import org.bm.b5.instructions.B5Instr;

public class B5Get extends B5Expr {

  public final B5Expr array;
  public final B5Expr index;

  public B5Get(B5Instr instr, B5Expr array, B5Expr index) {
    super(instr);
    this.array = array;
    this.index = index;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void resolveReferences() {
    array.resolveReferences();
    index.resolveReferences();
  }

}
