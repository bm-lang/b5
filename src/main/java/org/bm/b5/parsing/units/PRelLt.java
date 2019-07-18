package org.bm.b5.parsing.units;

import org.bm.b5.B5Program;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5RelLt;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PRelLt {
  public static B5Expr parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.LT);

    B5Expr left = PExpr.parse(reader, program, instr);

    reader.expect(B5Lang.WITH);

    B5Expr right = PExpr.parse(reader, program, instr);

    return new B5RelLt(instr, left, right);
  }
}
