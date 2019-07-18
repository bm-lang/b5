package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;

public class B5Jump extends B5Instr {

  public final String markName;

  public B5Mark linkedMark;

  public B5Jump(B5Block block, String markName) {
    super(block);
    this.markName = markName;
  }

  @Override
  public void check() {

  }

  @Override
  public void link() {
    linkedMark = block.findContextMark(markName);
  }

}
