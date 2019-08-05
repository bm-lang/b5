package org.bm.b5.formatting;

import org.bm.b5.core.B5Writer;

import java.io.OutputStream;
import java.util.List;
import java.util.function.Consumer;

public class FWriter extends B5Writer {

  public FWriter(OutputStream out) {
    super(out);
  }

  public void write(Enum<?> element) {
    write(element.name());
  }

  public <T> void writeList(Iterable<T> items, Consumer<T> consumer) {
    boolean separator = false;
    for (T item : items) {
      if (separator) {
        write(',');
        write(' ');
      }
      else {
        separator = true;
      }

      consumer.accept(item);
    }
  }

  public void write(String token) {
    super.write(token);
    write(' ');
  }

  public void writeLine() {
    write('\n');
  }

  public void writeLine(Enum<?> element) {
    super.write(element.name());
    write('\n');
  }

  public void writeLine(String token) {
    super.write(token);
    write('\n');
  }

  public void spacing() {
    if (!isLineBroken()) {
      breakLine();
    }
  }

}
