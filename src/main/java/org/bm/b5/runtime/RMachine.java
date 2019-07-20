package org.bm.b5.runtime;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.design.instructions.B5Declare;
import org.bm.b5.design.instructions.B5Instr;

import java.util.List;

public class RMachine {

  private final RScope globalScope;

  public RMachine() {
    this.globalScope = new RScope(null);
  }

  public void run(B5Program program) {
    for (B5Scalar scalar : program.scalars) {
      RValue scalarValue = invokeBlock(globalScope, scalar.init);

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

    return invokeBlock(scope, proc.body);
  }

  public RValue invokeBlock(RScope parentScope, B5Block block) {
    RProcess process = new RProcess(block);
    RScope scope = new RScope(parentScope);
    B5Instr instr = block.getLocalFirst();

    return process.run(scope, instr);
  }

}
