package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.design.instructions.B5Declare;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PDeclare {

  public static B5Declare parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.DECLARE);

    String name = reader.nextToken();

    reader.expect(B5Lang.AS);

    B5Type type = reader.nextType(program);

    B5Declare instr = new B5Declare(scope, name, type);

    reader.expect(B5Lang.WITH);

    instr.value = PExpr.parse(reader, program, instr);

    return instr;
  }

}
