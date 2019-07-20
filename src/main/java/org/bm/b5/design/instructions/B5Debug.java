package org.bm.b5.design.instructions;

import org.bm.b5.design.entities.B5Block;

import java.util.function.Consumer;

public class B5Debug extends B5Instr {

  public final String output;

  public B5Debug(B5Block block, String output) {
    super(block);
    this.output = output;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

  }

  @Override
  public void linkReferences() {

  }

  @Override
  public void walk(Consumer<B5Instr> consumer) {

  }
}
