package org.bm.b5.instructions;

import org.bm.b5.entities.B5Block;
import org.bm.b5.expressions.B5Expr;

import java.util.function.Consumer;

public class B5Return extends B5Instr {

  public B5Expr value;

  @Override
  public void walk(Consumer<B5Instr> consumer) {

  }

  public B5Return(B5Block parent) {
    super(parent);
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    value.checkTypes();
  }

  @Override
  public void linkReferences() {
    value.resolveReferences();
  }
}
