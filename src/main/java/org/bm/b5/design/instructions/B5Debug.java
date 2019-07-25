package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;

import java.util.List;
import java.util.function.Consumer;

public class B5Debug extends B5Instr {

  public final String output;

  public B5Debug(B5Scope scope, String output) {
    super(scope);
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
  public List<B5Instr> getChildren() {
    return null;
  }
}
