package org.bm.b5.design.instructions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class B5IfElse extends B5Instr {

  public B5Expr condition;
  public B5Instr thenInstr;
  public B5Instr elseInstr;

  public B5IfElse(B5Scope scope) {
    super(scope);
  }

  @Override
  public void linkCurrent() {
    condition.link();
    thenInstr.link();
    elseInstr.link();
  }

  @Override
  public void compileCurrent() {
    condition.compile();
    thenInstr.compile();
    elseInstr.compile();

    B5Type conditionType = condition.getResultingType();

    if (!parent.getProgram().isBoolType(conditionType)) {
      throw new B5Exception("expected condition to be bool");
    }
  }

  @Override
  public List<B5Instr> getChildren() {
    if (elseInstr != null) {
      return Arrays.asList(thenInstr, elseInstr);
    }

    return Collections.singletonList(thenInstr);
  }

}
