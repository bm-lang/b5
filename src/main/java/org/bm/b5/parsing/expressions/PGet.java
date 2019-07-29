package org.bm.b5.parsing.expressions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.expressions.B5Expr;
import org.bm.b5.design.expressions.B5Get;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;

public class PGet {

  public static B5Expr parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.GET);

    B5Expr array = PExpr.parse(reader, program, scope);

    reader.expect(B5Lang.INDEX);

    B5Expr index = PExpr.parse(reader, program, scope);

    return new B5Get(scope, array, index);
  }

}
