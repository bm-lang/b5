package org.bm.b5.design.instructions;

import org.bm.b5.design.entities.B5Block;

import java.util.function.Consumer;

public class B5Exit extends B5Instr {

  @Override
  public void walk(Consumer<B5Instr> consumer) {

  }

  public B5Exit(B5Block parent) {
    super(parent);
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

}
