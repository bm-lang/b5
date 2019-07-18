package org.bm.b5.design.collections;

import org.bm.b5.design.entities.B5Param;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Type;

public class B5Params extends B5Set<B5Param> {

  private final B5Proc proc;

  public B5Params(B5Proc proc) {
    this.proc = proc;
  }

  public void add(String name, B5Type type) {
    add(new B5Param(proc, name, type));
  }

}
