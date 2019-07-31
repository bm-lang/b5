package org.bm.b5.design.entities;

import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5NamedElement;

public class B5Param extends B5NamedElement implements B5Linkable {

  public final B5Proc parent;
  public final B5Type type;

  public B5Param(B5Proc parent, String name, B5Type type) {
    super(name);
    this.parent = parent;
    this.type = type;
  }

  @Override
  public void link() {

  }

  @Override
  public void compile() {

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
