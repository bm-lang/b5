package org.bm.b5.design.instructions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5Ref;

import java.util.List;

public class B5Set extends B5Instr {

  public B5Ref ref;
  public B5Expr value;

  public B5Set(B5Scope scope) {
    super(scope);
  }

  @Override
  public void linkCurrent() {
    ref.link();
    value.link();
  }

  @Override
  public void compileCurrent() {
    ref.compile();
    value.compile();

    B5Type refType = ref.getResultingType();
    B5Type valueType = value.getResultingType();

    if (!refType.accepts(valueType)) {
      throw new B5Exception(refType + " is not compatible with " + valueType);
    }
  }

  @Override
  public List<B5Instr> getChildren() {
    return null;
  }
}
