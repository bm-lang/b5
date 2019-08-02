package org.bm.b5.design.collections;

import org.bm.b5.B5Exception;
import org.bm.b5.design.entities.B5Param;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;

import java.util.function.BiConsumer;

public class B5Params extends B5Set<B5Param> {

  private final B5Proc proc;

  public B5Params(B5Proc proc) {
    this.proc = proc;
  }

  public void match(B5ExprList args, BiConsumer<B5Param, B5Expr> consumer) {
    if (args.size() != this.size()) {
      throw new B5Exception("expected " + this.size() + " arguments");
    }

    for (int i = 0; i < size(); i++) {
      consumer.accept(get(i), args.get(i));
    }
  }

  public void add(String name, B5Type type) {
    add(new B5Param(proc, name, type));
  }

}
