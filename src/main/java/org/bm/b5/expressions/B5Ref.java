package org.bm.b5.expressions;

import org.bm.b5.B5Referenceable;
import org.bm.b5.instructions.B5Instr;

import java.util.List;

public class B5Ref extends B5Expr {

  public final List<String> path;

  public B5Referenceable ref; // resolved reference

  public B5Ref(B5Instr parent, List<String> path) {
    super(parent);
    this.path = path;
  }

  @Override
  public void check() {

  }

}
