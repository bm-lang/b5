package org.bm.b5.parsing.expressions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5Fetch;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PFetch {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.FETCH);

    B5Proc proc = reader.nextProc(program);
    B5Fetch fetch = new B5Fetch(scope, proc);

    while (reader.pull(B5Lang.ARG)) {
      B5Expr arg = PExpr.parse(reader, program, scope);

      fetch.args.add(arg);
    }

    reader.expect(B5Lang.END);

    return fetch;
  }

}
