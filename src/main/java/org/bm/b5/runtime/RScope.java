package org.bm.b5.runtime;

import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5Literal;
import org.bm.b5.design.expressions.B5Ref;
import org.bm.b5.design.expressions.B5RelGt;

import java.util.HashMap;

public class RScope {

  private final HashMap<String, RValue> references;
  private final RScope parent;

  public RScope(RScope parent) {
    this.parent = parent;
    this.references = new HashMap<>();
  }

  public boolean isDefined(String name) {
    return references.containsKey(name) || parent != null && parent.isDefined(name);
  }

  public void define(String name, RValue value) {
    if (isDefined(name)) {
      throw new RException("reference already taken: " + name);
    }

    references.put(name, value);
  }

  public RValue get(String name) {
    if (references.containsKey(name)) {
      return references.get(name);
    }
    else if (parent != null) {
      return parent.get(name);
    }

    throw new RException("reference not found: " + name);
  }

  public RValue resolve(B5Expr expr) {
    if (expr instanceof B5Literal) {
      return RExpr.resolveLiteral(this, (B5Literal)expr);
    }
    else if (expr instanceof B5RelGt) {
      return RExpr.resolveGt(this, (B5RelGt)expr);
    }
    else if (expr instanceof B5Ref) {
      return RExpr.resolveRef(this, (B5Ref)expr);
    }
    else {
      throw new RException("not implemented expression: " + expr);
    }
  }

  public void set(String name, RValue value) {
    if (references.containsKey(name)) {
      references.put(name, value);
    }
    else if (parent != null) {
      parent.set(name, value);
    }
    else {
      throw new RException("reference not found: " + name);
    }
  }
}
