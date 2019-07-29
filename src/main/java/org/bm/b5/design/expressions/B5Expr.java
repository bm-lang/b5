package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Element;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;

abstract public class B5Expr extends B5Element {

  abstract public B5Type findType();

  abstract public void resolveReferences(); // TODO should this be inherited from B5Scope?

  public final B5Scope scope;

  public B5Expr(B5Scope scope) {
    this.scope = scope;
  }

  public B5Program getProgram() {
    return scope.getProgram();
  }

}
