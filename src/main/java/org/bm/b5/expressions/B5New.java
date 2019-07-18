package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5New extends B5Expr {

  public final B5Type type;

  public B5New(B5Instr instr, B5Type type) {
    super(instr);
    this.type = type;
  }

  @Override
  public void check() {

  }

  @Override
  public void resolve() {

  }

}
