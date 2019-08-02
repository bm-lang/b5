package org.bm.b5.runtime;

import org.bm.b5.design.expressions.*;
import org.bm.b5.runtime.values.RBool;
import org.bm.b5.runtime.values.RInt32;
import org.bm.b5.runtime.values.RNumber;
import org.bm.b5.runtime.values.RObject;

public class RExpr {

  public static RValue resolve(RScope scope, B5Expr expr) {
    if (expr instanceof B5Literal) {
      return resolveLiteral(scope, (B5Literal)expr);
    }
    else if (expr instanceof B5RelGt) {
      return resolveGt(scope, (B5RelGt)expr);
    }
    else if (expr instanceof B5Ref) {
      return resolveRef(scope, (B5Ref)expr);
    }
    else if (expr instanceof B5Fetch) {
      return resolveFetch(scope, (B5Fetch)expr);
    }
    else if (expr instanceof B5New) {
      return resolveNew(scope, (B5New)expr);
    }
    else if (expr instanceof B5NumAdd) {
      return resolveNumAdd(scope, (B5NumAdd)expr);
    }
    else {
      throw new RException("not implemented expression: " + expr);
    }
  }

  private static RValue resolveNumAdd(RScope scope, B5NumAdd expr) {
    RValue left = RExpr.resolve(scope, expr.left);
    RValue right = RExpr.resolve(scope, expr.right);

    if (left instanceof RNumber && right instanceof RNumber) {
      return ((RNumber)left).addition((RNumber)right);
    }
    else {
      throw new RException("not numbers");
    }
  }

  private static RValue resolveNew(RScope scope, B5New expr) {
    return new RObject(expr.type);
  }

  private static RValue resolveLiteral(RScope scope, B5Literal expr) {
    if (expr.getProgram().typeInt32 == expr.type) {
      return new RInt32(scope, Integer.parseInt(expr.value));
    }
    else {
      throw new RException("type not supported: " + expr.type);
    }
  }

  private static RValue resolveGt(RScope scope, B5RelGt expr) {
    RValue left = resolve(scope, expr.left);
    RValue right = resolve(scope, expr.right);

    if (left instanceof RInt32 && right instanceof RInt32) {
      return new RBool(scope, ((RInt32)left).getValue() > ((RInt32)right).getValue());
    }
    else {
      throw new RException("not supported comparison");
    }
  }

  private static RValue resolveRef(RScope scope, B5Ref expr) {
    if (expr.path.isEmpty()) {
      throw new RException("empty ref");
    }

    RValue value = scope.get(expr.path.get(0));

    for (int i = 1; i < expr.path.size(); i++) {
      value = value.get(expr.path.get(i));
    }

    return value;
  }

  private static RValue resolveFetch(RScope superScope, B5Fetch fetch) {
    RScope scope = superScope.subScope();

    fetch.proc.params.match(fetch.args, (param, value) -> {
      RValue rvalue = resolve(superScope, value);

      scope.set(param.name, rvalue);
    });

    return RInstr.run(scope, fetch.proc.body);
  }
}
