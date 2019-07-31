package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.collections.B5ExprList;
import org.bm.b5.design.entities.B5Param;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Type;

public class B5Fetch extends B5Expr {

  public final B5Proc proc;
  public final B5ExprList args;

  public B5Fetch(B5Scope scope, B5Proc proc) {
    super(scope);
    this.proc = proc;
    this.args = new B5ExprList();
  }

  @Override
  public void link() {
    args.linkAll();
  }

  @Override
  public void compile() {
    args.compileAll();

    B5Type[] argTypes = args.getResultingTypes();

    if (argTypes.length != proc.params.size()) {
      throw new B5Exception("expected " + proc.params.size() + " parameters");
    }

    for (int i = 0; i < argTypes.length; i++) {
      B5Param param = proc.params.get(i);

      if (!param.type.accepts(argTypes[i])) {
        throw new B5Exception("the type " + param.type + " is not compatible with " + argTypes[i]);
      }
    }

    if (proc.returnType == null) {
      throw new B5Exception("the proc " + proc + " doesn't have a return value");
    }

    setResultingType(proc.returnType);
  }

}
