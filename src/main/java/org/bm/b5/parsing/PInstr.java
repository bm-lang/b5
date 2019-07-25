package org.bm.b5.parsing;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.B5Scope;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.parsing.instructions.*;

public class PInstr {
  public static B5Instr parse(B5Reader reader, B5Program program, B5Scope scope) {
    if (reader.test(B5Lang.BEGIN)) {
      return PBlock.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.DECLARE)) {
      return PDeclare.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.SET)) {
      return PSet.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.IF)) {
      return PIfElse.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.LOOP)) {
      return PLoop.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.JUMP)) {
      return PJump.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.MARK)) {
      return PMark.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.CALL)) {
      return PCall.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.RETURN)) {
      return PReturn.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.EXIT)) {
      return PExit.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.PUT)) {
      return PPut.parse(reader, program, scope);
    }
    else if (reader.test(B5Lang.DEBUG)) {
      return PDebug.parse(reader, program, scope);
    }
    else {
      throw reader.error("unknown instruction: " + reader.nextToken());
    }
  }
}
