package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5Get extends B5Expr {

  public final B5Expr array;
  public final B5Expr index;

  public B5Get(B5Scope scope, B5Expr array, B5Expr index) {
    super(scope);
    this.array = array;
    this.index = index;
  }

  @Override
  public void link() {
    array.link();
    index.link();
  }

  @Override
  public void compile() {
    array.compile();
    index.compile();

    setResultingType(scope.getProgram().typeAny);
  }

}
