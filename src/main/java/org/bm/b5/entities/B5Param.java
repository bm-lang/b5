package org.bm.b5.entities;

import org.bm.b5.B5NamedElement;

public class B5Param extends B5NamedElement {

  public final B5Proc parent;
  public final B5Type type;

  public B5Param(B5Proc parent, String name, B5Type type) {
    super(name);
    this.parent = parent;
    this.type = type;
  }

  @Override
  public void check() {

  }

}
