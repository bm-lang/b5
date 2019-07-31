package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.expressions.B5Expr;

import java.util.List;
import java.util.function.Consumer;

public class B5Return extends B5Instr {

  public B5Expr value;

  public B5Return(B5Scope scope) {
    super(scope);
  }

  @Override
  public void linkCurrent() {
    value.link();
  }

  @Override
  public void compileCurrent() {
    value.compile();
  }

  @Override
  public List<B5Instr> getChildren() {
    return null;
  }
}
