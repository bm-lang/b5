package org.bm.b5.design.instructions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;

import java.util.List;

public class B5Declare extends B5Instr implements B5Linkable {

  public final String name;
  public final B5Type type;

  public B5Expr value;

  public B5Declare(B5Scope scope, String name, B5Type type) {
    super(scope);
    this.name = name;
    this.type = type;
  }

  @Override
  public void linkCurrent() {
    value.link();
  }

  @Override
  public void compileCurrent() {
    value.compile();

    B5Type valueType = value.getResultingType();

    if (!type.accepts(valueType)) {
      throw new B5Exception("initial value not compatible");
    }
  }

  @Override
  public List<B5Instr> getChildren() {
    return null;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public B5Linkable pick(String member) {
    return type.findField(member);
  }

  @Override
  public B5Type getType() {
    return type;
  }
}
