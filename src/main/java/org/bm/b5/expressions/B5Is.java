package org.bm.b5.expressions;

import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Instr;

public class B5Is extends B5Expr {

  public final B5Expr value;

  public final B5Type type;

  public B5Is(B5Instr instr, B5Expr value, B5Type type) {
    super(instr);
    this.value = value;
    this.type = type;
  }

  @Override
  public void check() {

  }

  @Override
  public void resolve() {
    value.resolve();
  }

}
