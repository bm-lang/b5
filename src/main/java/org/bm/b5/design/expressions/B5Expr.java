package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Element;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;

abstract public class B5Expr extends B5Element {

  public final B5Scope scope;

  private B5Type resultingType;

  public B5Expr(B5Scope scope) {
    this.scope = scope;
  }

  public void setResultingType(B5Type type) {
    if (resultingType == null) {
      throw new B5Exception("resulting type cannot be null");
    }
    else if (resultingType != null) {
      throw new B5Exception("resulting type already defined");
    }
    this.resultingType = type;
  }

  public B5Type getResultingType() {
    if (resultingType == null) {
      throw new B5Exception("resulting type was not compiled");
    }
    return resultingType;
  }

  public B5Program getProgram() {
    return scope.getProgram();
  }

}
