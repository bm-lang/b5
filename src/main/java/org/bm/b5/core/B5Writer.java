package org.bm.b5.core;

import org.bm.b5.B5Exception;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class B5Writer implements AutoCloseable {

  public final String DEFAULT_CHARSET = "UTF-8";

  private final OutputStreamWriter writer;

  private final String tabSymbol;

  private boolean brokenLine;
  private int indentation;

  public B5Writer(OutputStream out) {
    try {
      this.writer = new OutputStreamWriter(out, DEFAULT_CHARSET);
      this.tabSymbol = "  ";
    }
    catch (IOException e) {
      throw new B5Exception(e, "error creating the output writer");
    }
  }

  protected void indent(int delta) {
    indentation += delta;
  }

  protected void write(String item) {
    for (int i = 0; i < item.length(); i++) {
      write(item.charAt(i));
    }
  }

  protected void breakLine() {
    flush();

    brokenLine = true;
  }

  protected void write(char c) {
    flush();

    try {
      writer.write(c);
    }
    catch (IOException e) {
      throw new B5Exception(e, "error writing a character: " + c);
    }

    if (c == '\n') {
      brokenLine = true;
    }
  }

  public void flush() {
    if (brokenLine) {
      try {
        writer.write('\n');

        for (int i = 0; i < indentation; i++) {
          writer.write(tabSymbol);
        }

        brokenLine = false;
      }
      catch(IOException e) {
        throw new B5Exception(e, "error formatting the code");
      }
    }
  }

  @Override
  public void close() {
    try {
      flush();

      writer.flush();
    }
    catch (IOException e) {
      throw new B5Exception(e, "error flushing the writer");
    }
  }
}
