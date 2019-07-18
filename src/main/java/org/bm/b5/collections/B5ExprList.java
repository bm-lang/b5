package org.bm.b5.collections;

import org.bm.b5.entities.B5Type;
import org.bm.b5.expressions.B5Expr;

import java.util.ArrayList;

public class B5ExprList extends ArrayList<B5Expr> {

  public void resolveAll() {
    for (B5Expr expr : this) {
      expr.resolveReferences();
    }
  }

  public B5Type[] findTypes() {
    B5Type[] types = new B5Type[size()];

    for (int i = 0; i < types.length; i++) {
      types[i] = get(i).findType();
    }

    return types;
  }

  public void checkTypesAll() {
    for (B5Expr expr : this) {
      expr.checkTypes();
    }
  }
}
