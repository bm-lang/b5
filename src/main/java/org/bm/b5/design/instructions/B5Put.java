package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.expressions.B5Expr;

import java.util.List;

public class B5Put extends B5Instr {

  public B5Expr array;
  public B5Expr index;
  public B5Expr value;

  public B5Put(B5Scope scope) {
    super(scope);
  }

  @Override
  public void linkCurrent() {
    array.link();
    index.link();
    value.link();
  }

  @Override
  public void compileCurrent() {
    array.compile();
    index.compile();
    value.compile();
  }

  @Override
  public List<B5Instr> getChildren() {
    return null;
  }
}
