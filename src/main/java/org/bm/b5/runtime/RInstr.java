package org.bm.b5.runtime;

import org.bm.b5.design.instructions.*;
import org.bm.b5.runtime.values.RBool;
import org.bm.b5.runtime.values.RNull;

import java.util.ArrayList;

public class RInstr {


  public static RValue run(RScope scope, B5Instr instr) {
    RStack stack = new RStack();

    stack.push(scope, instr);

    do {
      RStack.Entry entry = stack.pop();

      if (entry.instr instanceof B5Call) {
        evalCall(stack, entry.scope, (B5Call) entry.instr);
      } else if (entry.instr instanceof B5Declare) {
        evalDeclare(stack, entry.scope, (B5Declare) entry.instr);
      } else if (entry.instr instanceof B5IfElse) {
        evalIfElse(stack, entry.scope, (B5IfElse) entry.instr);
      } else if (entry.instr instanceof B5Jump) {
        evalJump(stack, entry.scope, (B5Jump) entry.instr);
      } else if (entry.instr instanceof B5Loop) {
        evalLoop(stack, entry.scope, (B5Loop) entry.instr);
      } else if (entry.instr instanceof B5Mark) {
        evalMark(stack, entry.scope, (B5Mark) entry.instr);
      } else if (entry.instr instanceof B5Put) {
        evalPut(stack, entry.scope, (B5Put) entry.instr);
      } else if (entry.instr instanceof B5Set) {
        evalSet(stack, entry.scope, (B5Set) entry.instr);
      } else if (entry.instr instanceof B5Debug) {
        evalDebug(stack, entry.scope, (B5Debug) entry.instr);
      } else if (entry.instr instanceof B5Exit) {
        stack.clear();
        return null; // finalize the execution
      } else if (entry.instr instanceof B5Return) {
        stack.clear();
        return RExpr.resolve(entry.scope, ((B5Return)instr).value); // finalize the execution
      } else {
        throw new RException("not implemented instruction: " + entry.instr);
      }
    }
    while (stack.alive());

    return null;
  }

  private static void evalDebug(RStack stack, RScope scope, B5Debug instr) {
    System.out.println("DEBUG: " + instr.output);

    stack.push(scope, instr.next);
  }

  private static void evalCall(RStack stack, RScope scope, B5Call instr) {
    throw new RException("not implemented");
  }

  private static void evalDeclare(RStack stack, RScope scope, B5Declare instr) {
    String name = instr.name;
    RValue value = RExpr.resolve(scope, instr.value);

    scope.define(name, value);

    stack.push(scope, instr.next);
  }

  private static void evalIfElse(RStack stack, RScope scope, B5IfElse ifElse) {
    RValue result = RExpr.resolve(scope, ifElse.condition);

    if (result instanceof RBool) {
      RBool resultBool = (RBool)result;

      stack.push(scope, ifElse.next);

      if (resultBool.getValue()) {
        stack.push(scope.subScope(), ifElse.thenInstr);
      }
      else {
        stack.push(scope.subScope(), ifElse.elseInstr);
      }
    }
    else {
      throw new RException("expected boolean result");
    }
  }

  private static void evalJump(RStack stack, RScope scope, B5Jump instr) {
    if (instr.linkedMark == null) {
      throw new RException("not linked jump"); // TODO this validation should not be here
    }
    stack.push(scope, instr.linkedMark);
  }

  private static void evalLoop(RStack stack, RScope scope, B5Loop instr) {
    throw new RException("not implemented");
  }

  private static void evalMark(RStack stack, RScope scope, B5Mark instr) {
    throw new RException("not implemented");
  }

  private static void evalPut(RStack stack, RScope scope, B5Put instr) {
    throw new RException("not implemented");
  }

  private static void evalSet(RStack stack, RScope scope, B5Set instr) {
    RValue value = RExpr.resolve(scope, instr.value);

    if (instr.ref.path.isEmpty()) {
      throw new RException("empty ref"); // TODO remove this validation
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

    stack.push(scope, instr.next);
  }


}
