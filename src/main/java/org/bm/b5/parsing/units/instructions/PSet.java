package org.bm.b5.parsing.units.instructions;

import org.bm.b5.B5Program;
import org.bm.b5.collections.B5Block;
import org.bm.b5.instructions.B5Set;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PExpr;
import org.bm.b5.parsing.units.expressions.PRef;

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
