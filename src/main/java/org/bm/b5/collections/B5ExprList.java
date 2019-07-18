package org.bm.b5.collections;

import org.bm.b5.expressions.B5Expr;

import java.util.ArrayList;

public class B5ExprList extends ArrayList<B5Expr> {

  public void resolveAll() {
    for (B5Expr expr : this) {
      expr.resolve();
    }
  }

}
