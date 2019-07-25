package org.bm.b5.design.instructions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.collections.B5ExprList;
import org.bm.b5.design.entities.B5Param;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Type;

import java.util.List;
import java.util.function.Consumer;

public class B5Call extends B5Instr {

  public final B5Proc proc;
  public final B5ExprList args;

  public B5Call(B5Scope scope, B5Proc proc) {
    super(scope);
    this.proc = proc;
    this.args = new B5ExprList();
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    args.checkTypesAll();

    B5Type[] argTypes = args.findTypes();

    if (argTypes.length != proc.params.size()) {
      throw new B5Exception("expected " + proc.params.size() + " parameters");
    }

    for (int i = 0; i < argTypes.length; i++) {
      B5Param param = proc.params.get(i);

      if (!param.type.accepts(argTypes[i])) {
        throw new B5Exception("the type " + param.type + " is not compatible with " + argTypes[i]);
      }
    }
  }

  @Override
  public void linkReferences() {
    args.resolveAll();
  }

  @Override
  public List<B5Instr> getChildren() {
    return null;
  }
}
