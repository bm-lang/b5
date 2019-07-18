package org.bm.b5.parsing.expressions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5BitNot;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PBitNot {
  public static B5BitNot parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.BWN);

    B5Expr value = PExpr.parse(reader, program, instr);

    return new B5BitNot(instr, value);
  }
}
