package org.bm.b5.entities;

import org.bm.b5.B5NamedElement;
import org.bm.b5.B5Program;
import org.bm.b5.B5Element;

abstract public class B5Entity extends B5NamedElement {

  public final B5Program parent;

  public B5Entity(B5Program parent, String name) {
    super(name);
    this.parent = parent;
  }

}
