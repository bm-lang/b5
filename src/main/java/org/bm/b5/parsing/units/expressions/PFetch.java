package org.bm.b5.parsing.units.expressions;

import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5Fetch;
import org.bm.b5.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;

public class PFetch {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Instr instr) {
    reader.expect(B5Lang.FETCH);

    B5Proc proc = reader.nextProc(program);
    B5Fetch fetch = new B5Fetch(instr, proc);

    while (reader.pull(B5Lang.ARG)) {
      B5Expr arg = PExpr.parse(reader, program, instr);

      fetch.args.add(arg);
    }

    reader.expect(B5Lang.END);

    return fetch;
  }

}
