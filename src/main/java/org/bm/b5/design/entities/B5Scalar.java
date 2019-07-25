package org.bm.b5.design.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Instr;

public class B5Scalar extends B5Entity implements B5Linkable, B5Scope {

  public B5Instr init;
  public B5Type type;
  public boolean defined;

  public B5Scalar(B5Program program, String name) {
    super(program, name);
  }

  @Override
  public void checkDefinition() {
    if (!defined) {
      throw new B5Exception("the scalar " + name + " is not defined");
    }
  }

  @Override
  public void checkTypes() {
    init.checkTypes();

    B5Type returnType = init.getReturnType();

    if (returnType == null) {
      throw new B5Exception("the scalar " + name + " is not properly initialized");
    }
    else if (!type.accepts(returnType)) {
      throw new B5Exception(type + " is not compatible with " + returnType);
    }
  }

  @Override
  public void linkReferences() {
    init.linkReferences();
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

  @Override
  public B5Linkable findLinkable(String name) {
    return program.findLinkable(name);
  }

  @Override
  public B5Program getProgram() {
    return program;
  }
}
