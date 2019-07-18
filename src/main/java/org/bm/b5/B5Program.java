package org.bm.b5;

import org.bm.b5.collections.B5ProgramProcs;
import org.bm.b5.collections.B5ProgramScalars;
import org.bm.b5.collections.B5ProgramTypes;
import org.bm.b5.entities.B5Block;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.entities.B5Scalar;

import java.util.Objects;

public class B5Program implements B5Scope {

  public final B5ProgramTypes types;
  public final B5ProgramScalars scalars;
  public final B5ProgramProcs procs;

  public B5Proc main;

  public B5Program() {
    types = new B5ProgramTypes(this);
    scalars = new B5ProgramScalars(this);
    procs = new B5ProgramProcs(this);
  }

  public void check() {
    types.check();
    scalars.check();
    procs.check();
  }

  public void link() {
    for (B5Scalar scalar : scalars) {
      scalar.link();
    }

    for (B5Proc proc : procs) {
      proc.link();
    }
  }

  @Override
  public B5Linkable findLinkable(String name) {
    for (B5Scalar scalar : scalars) {
      if (Objects.equals(name, scalar.getName())) {
        return scalar;
      }
    }

    throw new B5Exception("program doesn't have a scalar named: " + name);
  }

  @Override
  public B5Block getContextBlock() {
    return null;
  }
}
