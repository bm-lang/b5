package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;

public class B5Cast extends B5Expr {

  public final B5Expr value;
  public final B5Type type;

  public B5Cast(B5Scope scope, B5Expr value, B5Type type) {
    super(scope);
    this.value = value;
    this.type = type;
  }

  @Override
  public void link() {
    value.link();
  }

  @Override
  public void compile() {
    value.compile();

    if (!type.accepts(value.getResultingType())) {
      throw new B5Exception("invalid cast");
    }

    setResultingType(type);
  }

}
