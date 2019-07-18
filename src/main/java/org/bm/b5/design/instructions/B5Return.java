package org.bm.b5.design.instructions;

import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.expressions.B5Expr;

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
