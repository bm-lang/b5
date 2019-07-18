package org.bm.b5.instructions;

import org.bm.b5.B5Scope;
import org.bm.b5.entities.B5Block;

public class B5Loop extends B5Instr implements B5Scope {

  public final String name;
  public final B5Block body;

  public B5Loop(B5Block parent, String name) {
    super(parent);
    this.name = name;
    this.body = new B5Block(this);
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void linkReferences() {
    body.linkReferences();
  }

}
