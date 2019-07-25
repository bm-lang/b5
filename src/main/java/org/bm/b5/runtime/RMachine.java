package org.bm.b5.runtime;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.design.instructions.B5Instr;

import java.util.List;

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
      invokeProc(globalScope, program.main, null);
    }
  }

  private RValue invokeProc(RScope parentScope, B5Proc proc, List<RValue> arguments) {
    RScope scope = new RScope(parentScope);

    for (int i = 0; i < proc.params.size(); i++) {
      String argName = proc.params.get(i).name;
      RValue argValue = arguments.get(i);

      scope.define(argName, argValue);
    }

    return runInstruction(scope, proc.body);
  }

  public RValue runInstruction(RScope parentScope, B5Instr instr) {
    RScope scope = new RScope(parentScope);
    RProcess process = new RProcess(scope);

    return process.run(scope, instr);
  }

}
