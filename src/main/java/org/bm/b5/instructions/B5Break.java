package org.bm.b5.instructions;

import org.bm.b5.collections.B5Block;

public class B5Break extends B5Instr {

  public final String loopName;
  public B5Loop loop;

  public B5Break(B5Block parent, String loopName) {
    super(parent);
    this.loopName = loopName;
  }

  @Override
  public void check() {

  }

}
