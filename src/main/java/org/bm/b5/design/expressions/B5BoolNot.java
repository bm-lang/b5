package org.bm.b5.design.expressions;

import org.bm.b5.B5Exception;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Instr;

public class B5BoolNot extends B5Expr {

  public final B5Expr value;

  public B5BoolNot(B5Instr instr, B5Expr value) {
    super(instr);
    this.value = value;
  }

  @Override
  public B5Type findType() {
    return instr.getProgram().typeBool;
  }

  @Override
  public void resolveReferences() {
    value.resolveReferences();
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {
    value.checkTypes();

    B5Type type = value.findType();

    if (!instr.getProgram().isBoolType(type)) {
      throw new B5Exception("expected " + type + " to be bool");
    }
  }
}
