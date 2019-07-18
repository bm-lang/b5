package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;

public class B5Break extends B5Instr {

  public final String loopName;

  public B5Loop linkedLoop;

  public B5Break(B5Block parent, String loopName) {
    super(parent);
    this.loopName = loopName;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void link() {
    linkedLoop = block.findContextLoop(loopName);
  }

}
