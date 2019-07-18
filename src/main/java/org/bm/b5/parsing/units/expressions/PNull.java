package org.bm.b5.parsing.units.expressions;

import org.bm.b5.B5Program;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5Null;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;

public class PNull {
  public static B5Null parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.NULL);

    return new B5Null(instr);
  }
}
