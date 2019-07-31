package org.bm.b5.design.expressions;

import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;

public class B5New extends B5Expr {

  public final B5Type type;

  public B5New(B5Scope scope, B5Type type) {
    super(scope);
    this.type = type;
  }

  @Override
  public void link() {

  }

  @Override
  public void compile() {
    setResultingType(type);
  }


}
