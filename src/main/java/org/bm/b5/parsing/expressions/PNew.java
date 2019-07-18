package org.bm.b5.parsing.expressions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5New;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PNew {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.NEW);

    B5Type type = reader.nextType(program);

    return new B5New(instr, type);
  }

}
