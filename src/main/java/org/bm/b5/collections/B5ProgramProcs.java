package org.bm.b5.collections;

import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Proc;

public class B5ProgramProcs extends B5Set<B5Proc> {

  public final B5Program parent;

  public B5ProgramProcs(B5Program parent) {
    this.parent = parent;
  }

  public B5Proc create(String name) {
    B5Proc proc = new B5Proc(parent, name);

    add(proc);

    return proc;
  }

  public B5Proc link(String name) {
    B5Proc proc = get(name);

    if (proc == null) {
      proc = create(name);
    }

    return proc;
  }
}
