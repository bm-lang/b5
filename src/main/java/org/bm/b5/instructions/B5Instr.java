package org.bm.b5.instructions;

import org.bm.b5.B5Element;
import org.bm.b5.collections.B5Block;

abstract public class B5Instr extends B5Element {

  public final B5Block parent;

  public B5Instr(B5Block parent) {
    this.parent = parent;
  }

}
