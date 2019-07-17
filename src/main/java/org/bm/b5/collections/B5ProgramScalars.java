package org.bm.b5.collections;

import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.entities.B5Scalar;
import org.bm.b5.entities.B5Type;

public class B5ProgramScalars extends B5Set<B5Scalar> {

  public final B5Program parent;

  public B5ProgramScalars(B5Program parent) {
    this.parent = parent;
  }

  public B5Scalar create(String name) {
    B5Scalar scalar = new B5Scalar(parent, name);

    add(scalar);

    return scalar;
  }

  public B5Scalar link(String name) {
    B5Scalar scalar = get(name);

    if (scalar == null) {
      scalar = create(name);
    }

    return scalar;
  }
}
