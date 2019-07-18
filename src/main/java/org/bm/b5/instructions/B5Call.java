package org.bm.b5.instructions;

import org.bm.b5.collections.B5ExprList;
import org.bm.b5.entities.B5Block;
import org.bm.b5.entities.B5Proc;

public class B5Call extends B5Instr {

  public final B5Proc proc;
  public final B5ExprList args;

  public B5Call(B5Block parent, B5Proc proc) {
    super(parent);
    this.proc = proc;
    this.args = new B5ExprList();
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void linkReferences() {
    args.resolveAll();
  }
}
