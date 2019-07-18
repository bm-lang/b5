package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;

import java.util.function.Consumer;

public class B5Mark extends B5Instr {

  public final String name;

  public B5Mark(B5Block parent, String name) {
    super(parent);
    this.name = name;
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
