package org.bm.b5.runtime;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.design.instructions.B5Instr;

public class RMachine {

  private final RScope globalScope;

  public RMachine() {
    this.globalScope = new RScope(null);
  }

  public void run(B5Program program) {
    for (B5Scalar scalar : program.scalars) {
      RValue scalarValue = runInstruction(globalScope, scalar.init);

      globalScope.define(scalar.name, scalarValue);
    }

    if (program.main != null) {
      runInstruction(globalScope, program.main.body);
    }
  }

  public RValue runInstruction(RScope parentScope, B5Instr instr) {
    RScope scope = new RScope(parentScope);

    return RInstr.run(scope, instr);
  }

}
