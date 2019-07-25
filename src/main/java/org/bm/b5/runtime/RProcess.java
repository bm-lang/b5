package org.bm.b5.runtime;

import org.bm.b5.design.instructions.*;
import org.bm.b5.runtime.values.RBool;
import org.bm.b5.runtime.values.RNull;

import java.util.Stack;

public class RProcess {

  private final Stack<B5Instr> instrs;
  private final RScope scope;

  private RValue result;

  public RProcess(RScope scope) {
    this.scope = scope;
    this.instrs = new Stack<>();
  }

  public RValue run(RScope scope, B5Instr instr) {
    instrs.push(instr);

    result = null;

    do {
      B5Instr next = instrs.pop();

      if (next instanceof B5Call) {
        evalCall(scope, (B5Call) next);
      } else if (next instanceof B5Declare) {
        evalDeclare(scope, (B5Declare) next);
      } else if (next instanceof B5Exit) {
        evalExit(scope, (B5Exit) next);
      } else if (next instanceof B5IfElse) {
        evalIfElse(scope, (B5IfElse) next);
      } else if (next instanceof B5Jump) {
        evalJump(scope, (B5Jump) next);
      } else if (next instanceof B5Loop) {
        evalLoop(scope, (B5Loop) next);
      } else if (next instanceof B5Mark) {
        evalMark(scope, (B5Mark) next);
      } else if (next instanceof B5Put) {
        evalPut(scope, (B5Put) next);
      } else if (next instanceof B5Return) {
        evalReturn(scope, (B5Return) next);
      } else if (next instanceof B5Set) {
        evalSet(scope, (B5Set) next);
      } else if (next instanceof B5Debug) {
        evalDebug(scope, (B5Debug) next);
      } else {
        throw new RException("not implemented instruction: " + next);
      }
    }
    while (instrs.size() > 0);

    return result;
  }

  private void gotoNext(B5Instr instr) {
    if (instr.next != null) {
      instrs.push(instr.next);
    }
  }

  private void evalDebug(RScope scope, B5Debug instr) {
    System.out.println("DEBUG: " + instr.output);

    gotoNext(instr);
  }

  private void evalCall(RScope scope, B5Call instr) {
    throw new RException("not implemented");
  }

  private void evalDeclare(RScope scope, B5Declare instr) {
    String name = instr.name;

    scope.define(name, new RNull());

    gotoNext(instr);
  }

  private void evalExit(RScope scope, B5Exit instr) {
    // finalize the execution
    instrs.clear();
  }

  private void evalIfElse(RScope scope, B5IfElse instr) {
    RValue result = scope.resolve(instr.condition);

    if (result instanceof RBool) {
      RBool resultBool = (RBool)result;

      gotoNext(instr);

      if (resultBool.getValue()) {
        instrs.push(instr.thenInstr);
      }
      else if (instr.elseInstr != null) {
        instrs.push(instr.elseInstr);
      }
    }
    else {
      throw new RException("expected boolean result");
    }
  }

  private void evalJump(RScope scope, B5Jump instr) {
    if (instr.linkedMark == null) {
      throw new RException("not linked jump");
    }
    instrs.add(instr.linkedMark);
  }

  private void evalLoop(RScope scope, B5Loop instr) {
    throw new RException("not implemented");
  }

  private void evalMark(RScope scope, B5Mark instr) {
    throw new RException("not implemented");
  }

  private void evalPut(RScope scope, B5Put instr) {
    throw new RException("not implemented");
  }

  private void evalReturn(RScope scope, B5Return instr) {
    // finalize the execution
    result = scope.resolve(instr.value);

    instrs.clear();
  }

  private void evalSet(RScope scope, B5Set instr) {
    RValue value = scope.resolve(instr.value);

    if (instr.ref.path.isEmpty()) {
      throw new RException("empty ref");
    }
    else if (instr.ref.path.size() == 1) {
      scope.set(instr.ref.path.get(0), value);
    }
    else {
      RValue root = scope.get(instr.ref.path.get(0));

      for (int i = 1; i < instr.ref.path.size() - 1; i++) {
        root = root.get(instr.ref.path.get(i));
      }

      String member = instr.ref.path.get(instr.ref.path.size() - 1);

      root.set(member, value);
    }

    gotoNext(instr);
  }


}
