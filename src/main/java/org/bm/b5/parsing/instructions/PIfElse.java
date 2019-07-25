package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5IfElse;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;
import org.bm.b5.parsing.PInstr;

public class PIfElse {

  public static B5IfElse parse(B5Reader reader, B5Program program, B5Scope scope) {
    B5IfElse ifElse = new B5IfElse(scope);

    reader.expect(B5Lang.IF);

    ifElse.condition = PExpr.parse(reader, program, ifElse);

    reader.expect(B5Lang.THEN);

    ifElse.thenInstr = PInstr.parse(reader, program, ifElse);

    if (reader.pull(B5Lang.ELSE)) {
      ifElse.elseInstr = PInstr.parse(reader, program, ifElse);
    }

    return ifElse;
  }

}
