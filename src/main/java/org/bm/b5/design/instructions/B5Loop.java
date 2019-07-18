package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Block;

import java.util.function.Consumer;

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
  public void checkTypes() {
    body.checkTypes();
  }

  @Override
  public void linkReferences() {
    body.linkReferences();
  }

  @Override
  public void walk(Consumer<B5Instr> consumer) {
    body.walk(consumer);
  }
}
