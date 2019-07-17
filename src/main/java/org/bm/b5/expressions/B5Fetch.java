package org.bm.b5.expressions;

import org.bm.b5.B5Program;
import org.bm.b5.collections.B5Args;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.instructions.B5Instr;

public class B5Fetch extends B5Expr {

  public final B5Proc proc;
  public final B5Args args;

  public B5Fetch(B5Instr parent, B5Proc proc) {
    super(parent);
    this.proc = proc;
    this.args = new B5Args();
  }

  @Override
  public void check() {

  }
}
