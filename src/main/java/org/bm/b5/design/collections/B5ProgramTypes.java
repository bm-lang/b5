package org.bm.b5.design.collections;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Type;

public class B5ProgramTypes extends B5Set<B5Type> {

  public final B5Program parent;

  public B5ProgramTypes(B5Program parent) {
    this.parent = parent;
  }

  public B5Type create(String name) {
    B5Type proc = new B5Type(parent, name);

    add(proc);

    return proc;
  }

  public B5Type link(String name) {
    B5Type proc = get(name);

    if (proc == null) {
      proc = create(name);
    }

    return proc;
  }
}
