package org.bm.b5.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Linkable;
import org.bm.b5.B5Program;
import org.bm.b5.B5Scope;

public class B5Scalar extends B5Entity implements B5Linkable, B5Scope {

  public final B5Block init;

  public B5Type type;
  public boolean defined;

  public B5Scalar(B5Program program, String name) {
    super(program, name);
    this.init = new B5Block(this);
  }

  @Override
  public void checkDefinition() {
    if (!defined) {
      throw new B5Exception("the scalar " + name + " is not defined");
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
  public B5Block getContextBlock() {
    return null;
  }

  @Override
  public B5Program getProgram() {
    return program;
  }
}
