package org.bm.b5.formatting;

import org.bm.b5.design.entities.B5Type;
import org.bm.b5.formatting.FWriter;
import org.bm.b5.parsing.B5Lang;

public class FType {
  public static void write(FWriter writer, B5Type type) {
    writer.write(B5Lang.TYPE);

    if (type.superType != null) {
      writer.write(type.name);
      writer.write(B5Lang.EXTENDS);
      writer.writeLine(type.superType.name);
    }
    else {
      writer.writeLine(type.name);
    }

    if (type.fields.notEmpty()) {
      writer.write(B5Lang.FIELDS);
      writer.writeList(type.fields, (field) -> {
        writer.write(field.name);
        writer.writeLine(field.type.name);
      });
    }
  }
}
