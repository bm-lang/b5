package org.bm.b5.parsing.expressions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5Is;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PIs {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.IS);

    B5Expr value = PExpr.parse(reader, program, instr);

    reader.expect(B5Lang.OF);

    B5Type type = reader.nextType(program);

    return new B5Is(instr, value, type);
  }

}
