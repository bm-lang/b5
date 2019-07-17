package org.bm.b5.parsing.units.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.entities.B5Type;
import org.bm.b5.parsing.B5Lang;
import org.bm.b5.parsing.B5Reader;
import org.bm.b5.parsing.units.PBlock;

public class PProc {

  public static void parse(B5Reader reader, B5Program program) {
    reader.expect(B5Lang.PROC);

    B5Proc proc = reader.nextProc(program);

    if (proc.defined) {
      throw reader.error("the procedure '" +  proc + "' is already defined");
    }

    while (reader.pull(B5Lang.PARAM)) {
      String paramName = reader.nextToken();

      reader.expect(B5Lang.AS);

      B5Type paramType = reader.nextType(program);

      proc.params.add(paramName, paramType);
    }

    if (reader.pull(B5Lang.MAIN)) {
      if (program.main != null) {
        throw reader.error("program already has main: " + program.main);
      }

      if (reader.test(B5Lang.RETURNS)) {
        throw reader.error("main procs cannot return values: " + proc);
      }

      program.main = proc;
    }
    else if (reader.pull(B5Lang.RETURNS)) {
      proc.returnType = reader.nextType(program);
    }

    reader.expect(B5Lang.BODY);

    PBlock.parse(reader, program, proc.body, B5Lang.END);

    reader.expect(B5Lang.END);

    proc.defined = true;
  }

}
