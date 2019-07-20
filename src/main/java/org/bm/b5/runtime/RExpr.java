package org.bm.b5.runtime;

import org.bm.b5.design.expressions.B5Literal;
import org.bm.b5.design.expressions.B5Ref;
import org.bm.b5.design.expressions.B5RelGt;
import org.bm.b5.runtime.values.RBool;
import org.bm.b5.runtime.values.RInt32;

public class RExpr {
  public static RValue resolveLiteral(RScope scope, B5Literal expr) {
    if (expr.getProgram().typeInt32 == expr.type) {
      return new RInt32(Integer.parseInt(expr.value));
    }
    else {
      throw new RException("type not supported: " + expr.type);
    }
  }

  public static RValue resolveGt(RScope scope, B5RelGt expr) {
    RValue left = scope.resolve(expr.left);
    RValue right = scope.resolve(expr.right);

    if (left instanceof RInt32 && right instanceof RInt32) {
      return new RBool(((RInt32)left).getValue() > ((RInt32)right).getValue());
    }
    else {
      throw new RException("not supported comparison");
    }
  }

  public static RValue resolveRef(RScope scope, B5Ref expr) {
    if (expr.path.isEmpty()) {
      throw new RException("empty ref");
    }

    RValue value = scope.get(expr.path.get(0));

    for (int i = 1; i < expr.path.size(); i++) {
      value = value.get(expr.path.get(i));
    }

    return value;
  }
}
