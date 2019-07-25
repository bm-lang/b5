package org.bm.b5.design.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.collections.B5Params;
import org.bm.b5.design.instructions.B5Instr;

import java.util.Objects;

public class B5Proc extends B5Entity implements B5Scope {

  public final B5Params params;

  public B5Instr body;
  public B5Type returnType;

  public boolean defined;

  public B5Proc(B5Program program, String name) {
    super(program, name);
    this.params = new B5Params(this);
  }

  @Override
  public void checkDefinition() {
    if (!defined) {
      throw new B5Exception("the proc " + name + " is not defined");
    }
  }

  @Override
  public void checkTypes() {
    params.checkTypesAll();
    body.checkTypes();

    B5Type bodyReturnType = body.getReturnType();

    if (returnType != null && bodyReturnType != null) {
      if (!returnType.accepts(bodyReturnType)) {
        throw new B5Exception("the type " + returnType + " is not compatible with " + bodyReturnType);
      }
    }
    else if (returnType != null) {
      throw new B5Exception("the block should return " + returnType);
    }
    else if (bodyReturnType != null) {
      throw new B5Exception("the block should not return a value: " + bodyReturnType);
    }
  }

  @Override
  public void linkReferences() {
    body.linkReferences();
  }

  @Override
  public B5Linkable findLinkable(String name) {
    for (B5Param param : params) {
      if (Objects.equals(name, param.getName())) {
        return param;
      }
    }

    return program.findLinkable(name);
  }

  @Override
  public B5Program getProgram() {
    return program;
  }

}
