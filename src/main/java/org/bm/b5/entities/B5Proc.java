package org.bm.b5.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Linkable;
import org.bm.b5.B5Program;
import org.bm.b5.B5Scope;
import org.bm.b5.collections.B5Params;

import java.util.Objects;

public class B5Proc extends B5Entity implements B5Scope {

  public final B5Params params;
  public final B5Block body;

  public boolean defined;
  public B5Type returnType;

  public B5Proc(B5Program program, String name) {
    super(program, name);
    this.params = new B5Params(this);
    this.body = new B5Block(this);
  }

  @Override
  public void checkDefinition() {
    if (!defined) {
      throw new B5Exception("the proc " + name + " is not defined");
    }
  }

  @Override
  public void link() {
    body.link();
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
  public B5Block getContextBlock() {
    return null;
  }
}
