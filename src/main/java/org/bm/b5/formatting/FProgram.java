package org.bm.b5.formatting;

import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.design.entities.B5Type;

public class FProgram {
  public static void write(FWriter writer, B5Program program) {
    for (B5Type type : program.types) {
      FType.write(writer, type);

      writer.spacing();
    }

    for (B5Scalar scalar : program.scalars) {
      FScalar.write(writer, scalar);

      writer.spacing();
    }

    for (B5Proc proc : program.procs) {
      FProc.write(writer, proc);

      writer.spacing();
    }
  }
}
