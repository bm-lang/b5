package org.bm.b5.design.instructions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;

import java.util.function.Consumer;

public class B5IfElse extends B5Instr {

  public final B5Block thenBody;
  public final B5Block elseBody;

  public B5Expr condition;

  @Override
  public void walk(Consumer<B5Instr> consumer) {
    thenBody.walk(consumer);
    elseBody.walk(consumer);
  }

  public B5IfElse(B5Block parent) {
    super(parent);
    this.thenBody = new B5Block(this);
    this.elseBody = new B5Block(this);
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    condition.checkTypes();
    thenBody.checkTypes();
    elseBody.checkTypes();

    B5Type conditionType = condition.findType();

    if (!getProgram().isBoolType(conditionType)) {
      throw new B5Exception("expected condition to be bool");
    }
  }

  @Override
  public void linkReferences() {
    condition.resolveReferences();

    thenBody.linkReferences();
    elseBody.linkReferences();
  }

}
