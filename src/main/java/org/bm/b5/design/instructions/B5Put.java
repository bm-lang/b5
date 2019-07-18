package org.bm.b5.design.instructions;

import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.expressions.B5Expr;

import java.util.function.Consumer;

public class B5Put extends B5Instr {

  public B5Expr array;
  public B5Expr index;
  public B5Expr value;

  @Override
  public void walk(Consumer<B5Instr> consumer) {

  }

  public B5Put(B5Block parent) {
    super(parent);
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    array.checkTypes();
    index.checkTypes();
    value.checkTypes();
  }

  @Override
  public void linkReferences() {
    array.resolveReferences();
    index.resolveReferences();
    value.resolveReferences();
  }
}
