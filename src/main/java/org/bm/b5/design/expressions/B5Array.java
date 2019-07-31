package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Array extends B5Expr {

  public final B5Expr size;

  public B5Array(B5Scope scope, B5Expr size) {
    super(scope);
    this.size = size;
  }

  @Override
  public void link() {
    size.link();
  }

  @Override
  public void compile() {
    size.compile();

    setResultingType(scope.getProgram().typeArray);
  }

}
