package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.instructions.B5Set;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PExpr;
import org.bm.b5.parsing.expressions.PRef;

public class PSet {

  public static void parse(B5Reader reader, B5Program program, B5Block block) {
    B5Set set = new B5Set(block);

    reader.expect(B5Lang.SET);

    set.ref = PRef.parse(reader, program, set);

    reader.expect(B5Lang.VALUE);

    set.value = PExpr.parse(reader, program, set);

    block.add(set);
  }

}
