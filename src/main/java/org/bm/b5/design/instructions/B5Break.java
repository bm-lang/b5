package org.bm.b5.design.instructions;

import org.bm.b5.design.entities.B5Block;

import java.util.function.Consumer;

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
  public void checkTypes() {

  }

  @Override
  public void linkReferences() {
    linkedLoop = block.findContextLoop(loopName);
  }

  @Override
  public void walk(Consumer<B5Instr> consumer) {

  }
}
