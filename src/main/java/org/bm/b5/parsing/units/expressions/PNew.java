package org.bm.b5.parsing.units.expressions;

import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Type;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5New;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PNew {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.NEW);

    B5Type type = reader.nextType(program);

    return new B5New(instr, type);
  }

}
