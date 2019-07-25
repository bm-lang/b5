package org.bm.b5.parsing.entities;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.PInstr;
import org.bm.b5.parsing.instructions.PBlock;

public class PProc {

  public static void parse(B5Reader reader, B5Program program) {
    reader.expect(B5Lang.PROC);

    B5Proc proc = reader.nextProc(program);

    if (proc.defined) {
      throw reader.error("the procedure '" +  proc + "' is already defined");
    }

    if (reader.pull(B5Lang.MAIN)) {
      if (program.main != null) {
        throw reader.error("program already has main: " + program.main);
      }

      program.main = proc;
    }

    if (reader.pull(B5Lang.PARAMS)) {
      do {
        String paramName = reader.nextToken();

        reader.expect(B5Lang.AS);

        B5Type paramType = reader.nextType(program);

        proc.params.add(paramName, paramType);
      }
      while (reader.pull(','));
    }

    if (reader.pull(B5Lang.RETURNS)) {
      proc.returnType = reader.nextType(program);
    }

    reader.expect(B5Lang.BODY);

    proc.body = PInstr.parse(reader, program, proc);

    proc.defined = true;
  }

}
