package org.bm.b5.design.collections;

import org.bm.b5.B5Exception;
import org.bm.b5.design.entities.B5Param;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class B5ExprList extends ArrayList<B5Expr> {

  public void linkAll() {
    for (B5Expr expr : this) {
      expr.link();
    }
  }

  public void compileAll() {
    for (B5Expr expr : this) {
      expr.compile();
    }
  }

  public B5Type[] getResultingTypes() {
    B5Type[] types = new B5Type[size()];

    for (int i = 0; i < types.length; i++) {
      types[i] = get(i).getResultingType();
    }

    return types;
  }
}
