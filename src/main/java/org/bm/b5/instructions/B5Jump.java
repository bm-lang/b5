package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;

public class B5Jump extends B5Instr {

  public final String markName;

  public B5Jump(B5Block parent, String markName) {
    super(parent);
    this.markName = markName;
  }

  @Override
  public void check() {

  }

}
