package org.bm.b5.formatting;

import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.instructions.B5Instr;
import org.bm.b5.formatting.FWriter;
import org.bm.b5.parsing.B5Lang;

public class FProc {
  public static void write(FWriter writer, B5Proc proc) {
    writer.write(B5Lang.PROC);
    writer.writeLine(proc.name);

    if (proc.program.main == proc) {
      writer.writeLine(B5Lang.MAIN);
    }

    if (proc.params.notEmpty()) {
      writer.write(B5Lang.PARAMS);
      writer.writeList(proc.params, param -> {
        writer.write(param.name);
        writer.write(B5Lang.AS);
        writer.writeLine(param.type.name);
      });
    }

    if (proc.returnType != null) {
      writer.write(B5Lang.RETURNS);
      writer.writeLine(proc.returnType.name);
    }

    writer.write(B5Lang.BODY);
    FInstr.write(writer, proc.body);
    writer.writeLine();
  }
}
