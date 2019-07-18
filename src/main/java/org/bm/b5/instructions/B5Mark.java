package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;

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
  public void linkReferences() {

  }

}
