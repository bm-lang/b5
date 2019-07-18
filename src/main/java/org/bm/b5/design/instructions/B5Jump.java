package org.bm.b5.design.instructions;

import org.bm.b5.design.entities.B5Block;

import java.util.function.Consumer;

public class B5Jump extends B5Instr {

  public final String markName;

  public B5Mark linkedMark;

  public B5Jump(B5Block block, String markName) {
    super(block);
    this.markName = markName;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

  }

  @Override
  public void linkReferences() {
    linkedMark = block.findContextMark(markName);
  }

  @Override
  public void walk(Consumer<B5Instr> consumer) {

  }
}
