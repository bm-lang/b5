package org.bm.b5.compilation.c;

import org.bm.b5.compilation.B5Writer;

import java.io.OutputStream;

public class CWriter extends B5Writer {

  public CWriter(OutputStream out) {
    super(out);
  }

  public void openStruct(String name) {
    write("struct ");
    write(name);
    write(" {");
    indent(+1);
    breakLine();
  }

  public void closeStruct() {
    indent(-1);
    write("};");
    breakLine();
  }

  public void comment(String message) {
    write("// ");
    write(message);
    breakLine();
  }

  public void structField(String fieldName, String fieldType) {
    write(fieldType);
    write(" ");
    write(fieldName);
    write(";");
    breakLine();
  }

  public void beginFunction(String name, String returnType) {
    write(returnType);
    write(" ");
    write(name);
  }

  public void beginParameters() {
    write("(");
  }

  public void endParameters() {
    write(")");
  }

  public void beginBlock() {
    write(" {");
    indent(+1);
    breakLine();
  }

  public void endBlock() {
    indent(-1);
    write("}");
    breakLine();
  }

  public void endFunction() {
    // do nothing
  }

  public void writeVarDef(String type, String name) {
    write("struct obj* ");
    write(name);
    write(" = NULL; // type: ");
    write(type);
    breakLine();
  }
}
