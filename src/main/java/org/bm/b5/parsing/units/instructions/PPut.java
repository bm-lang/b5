package org.bm.b5.parsing.units.instructions;

import org.bm.b5.B5Program;
import org.bm.b5.collections.B5Block;
import org.bm.b5.expressions.B5Expr;
import org.bm.b5.expressions.B5Get;
import org.bm.b5.instructions.B5Put;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;

public class PPut {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    B5Put put = new B5Put(block);

    reader.expect(B5Lang.PUT);

    put.array = PExpr.parse(reader, program, put);

    reader.expect(B5Lang.INDEX);

    put.index = PExpr.parse(reader, program, put);

    reader.expect(B5Lang.VALUE);

    put.value = PExpr.parse(reader, program, put);

    block.add(put);
  }

}
