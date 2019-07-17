package org.bm.b5.parsing.units;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Program;
import org.bm.b5.collections.B5Block;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.instructions.*;

public class PBlock {

  public static void parse(B5Reader reader, B5Program program, B5Block block, Enum<?>... escapes) {
    while(!reader.test(escapes)) {
      if (reader.test(B5Lang.DECLARE)) {
        PDeclare.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.SET)) {
        PSet.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.IF)) {
        PIfElse.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.LOOP)) {
        PLoop.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.BREAK)) {
        PBreak.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.JUMP)) {
        PJump.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.MARK)) {
        PMark.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.CALL)) {
        PCall.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.RETURN)) {
        PReturn.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.EXIT)) {
        PExit.parse(reader, program, block);
      }
      else if (reader.test(B5Lang.PUT)) {
        PPut.parse(reader, program, block);
      }
      else {
        throw reader.error("unknown instruction: " + reader.nextToken());
      }
    }
  }

}
