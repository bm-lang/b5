package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;

import java.util.List;
import java.util.function.Consumer;

public class B5Nop extends B5Instr {

  public B5Nop(B5Scope scope) {
    super(scope);
  }

  @Override
  public void linkReferences() {

  }

  @Override
  public List<B5Instr> getChildren() {
    return null;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

  }
}
