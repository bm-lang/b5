package org.bm.b5.instructions;

import org.bm.b5.collections.B5Block;
import org.bm.b5.collections.B5Args;
import org.bm.b5.entities.B5Proc;

public class B5Call extends B5Instr {

  public final B5Proc proc;
  public final B5Args args;

  public B5Call(B5Block parent, B5Proc proc) {
    super(parent);
    this.proc = proc;
    this.args = new B5Args();
  }

  @Override
  public void check() {

  }
}
