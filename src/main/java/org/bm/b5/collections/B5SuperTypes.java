package org.bm.b5.collections;

import org.bm.b5.entities.B5Type;

public class B5SuperTypes extends B5Set<B5Type> {

  public final B5Type parent;

  public B5SuperTypes(B5Type parent) {
    this.parent = parent;
  }

}
