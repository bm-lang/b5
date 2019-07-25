package org.bm.b5.formatting;

import org.bm.b5.core.B5Writer;

import java.io.OutputStream;

public class FWriter extends B5Writer {

  public FWriter(OutputStream out) {
    super(out);
  }

  public void write(Enum<?> element) {
    write(element.name());
  }

  public void write(String token) {
    super.write(token);
    write(' ');
  }

  public void writeLine(String token) {
    super.write(token);
    write(' ');
  }

  public void spacing() {
    if (!isLineBroken()) {
      breakLine();
    }

    breakLine();
  }

}
