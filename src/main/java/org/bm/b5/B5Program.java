package org.bm.b5;

import org.bm.b5.collections.B5ProgramProcs;
import org.bm.b5.collections.B5ProgramScalars;
import org.bm.b5.collections.B5ProgramTypes;
import org.bm.b5.entities.B5Proc;

public class B5Program {

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
}
