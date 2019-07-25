package org.bm.b5.parsing.instructions;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Loop;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PInstr;

public class PLoop {
  
  public static B5Loop parse(B5Reader reader, B5Program program, B5Scope scope) {
    reader.expect(B5Lang.LOOP);

    B5Loop loop = new B5Loop(scope);

    loop.instr = PInstr.parse(reader, program, loop);

    return loop;
  }

}
