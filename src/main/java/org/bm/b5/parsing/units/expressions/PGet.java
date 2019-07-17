package org.bm.b5.parsing.units.expressions;

import org.bm.b5.B5Program;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5Get;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;

public class PGet {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.GET);

    B5Expr array = PExpr.parse(reader, program, instr);

    reader.expect(B5Lang.INDEX);

    B5Expr index = PExpr.parse(reader, program, instr);

    return new B5Get(instr, array, index);
  }

}
