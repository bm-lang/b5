package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.instructions.B5Call;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PCall {

  public static B5Call parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.CALL);

    B5Proc proc = reader.nextProc(program);
    
    B5Call call = new B5Call(scope, proc);

    if (reader.pull(B5Lang.ARGS)) {
      do {
        B5Expr arg = PExpr.parse(reader, program, call);

        call.args.add(arg);
      }
      while (reader.pull(','));
    }

    return call;
  }

}
