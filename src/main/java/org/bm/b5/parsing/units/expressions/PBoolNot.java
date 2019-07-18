package org.bm.b5.parsing.units.expressions;

import org.bm.b5.B5Program;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5BoolNot;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;

public class PBoolNot {
  public static B5BoolNot parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.NOT);

    B5Expr value = PExpr.parse(reader, program, instr);

    return new B5BoolNot(instr, value);
  }
}
