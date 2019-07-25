package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;

import java.util.List;
import java.util.function.Consumer;

public class B5Mark extends B5Instr {

  public final String name;

  public B5Mark(B5Scope scope, String name) {
    super(scope);
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
  public List<B5Instr> getChildren() {
    return null;
  }

}
