package org.bm.b5.parsing.units.instructions;

import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Block;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.instructions.B5Call;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;

public class PCall {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    reader.expect(B5Lang.CALL);

    B5Proc proc = reader.nextProc(program);
    B5Call call = new B5Call(block, proc);

    while (reader.pull(B5Lang.ARG)) {
      B5Expr arg = PExpr.parse(reader, program, call);

      call.args.add(arg);
    }

    reader.expect(B5Lang.END);
  }

}
