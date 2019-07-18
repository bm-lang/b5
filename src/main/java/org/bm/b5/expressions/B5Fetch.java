package org.bm.b5.expressions;

import org.bm.b5.collections.B5ExprList;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.instructions.B5Instr;

public class B5Fetch extends B5Expr {

  public final B5Proc proc;
  public final B5ExprList args;

  public B5Fetch(B5Instr instr, B5Proc proc) {
    super(instr);
    this.proc = proc;
    this.args = new B5ExprList();
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void resolve() {
    args.resolveAll();
  }
}
