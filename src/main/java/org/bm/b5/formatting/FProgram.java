package org.bm.b5.formatting;

import org.bm.b5.core.B5Writer;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.formatting.entities.FProc;
import org.bm.b5.formatting.entities.FScalar;
import org.bm.b5.formatting.entities.FType;

public class FProgram {
  public void write(FWriter writer, B5Program program) {
    for (B5Type type : program.types) {
      FType.write(writer, type);
    }

    writer.spacing();

    for (B5Scalar scalar : program.scalars) {
      FScalar.write(writer, scalar);
    }

    writer.spacing();

    for (B5Proc proc : program.procs) {
      FProc.write(writer, proc);
    }
  }
}
