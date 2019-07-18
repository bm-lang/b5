package org.bm.b5.parsing;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.entities.B5Proc;
import org.bm.b5.design.entities.B5Scalar;
import org.bm.b5.design.entities.B5Type;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class B5Reader {

  public static final int EOF = 0;

  private final Reader reader;

  private boolean alive;

  private int line;
  private int column;

  private char charBuffer;
  private String symbolBuffer;

  public B5Reader(Reader reader) {
    this.reader = reader;
    this.alive = true;
    this.charBuffer = EOF;
    this.symbolBuffer = null;
    this.line = 1;
    this.column = 0;
  }

//  public void expectAny(String... symbols) {
//    boolean error = true;
//    String actual = next();
//
//    if (actual != null) {
//      for (String expected : symbols) {
//        if (actual.equals(expected)) {
//          error = false;
//          break;
//        }
//      }
//    }
//
//    if (error) {
//      throw new B5Exception("expected any of symbols '" + String.join("', '", symbols) + "' at " + location());
//    }
//  }

  public void expect(Enum<?> expected) {
    if (!pull(expected)) {
      throw error("expected symbol '" + expected + "'");
    }
  }

  public boolean test(Enum<?>... symbols) {
    for (Enum<?> symbol : symbols) {
      String symbolName = symbol.name();
      String actual = peek();

      if (actual != null && actual.equals(symbolName)) {
        return true;
      }
    }

    return false;
  }

  public boolean pull(Enum<?> expected) {
    String actual = peek();

    if (actual != null && actual.equals(expected.name())) {
      symbolBuffer = null;
      return true;
    }

    return false;
  }

  public B5Type nextType(B5Program program) {
    String name = next();

    return program.types.link(name);
  }

  public B5Proc nextProc(B5Program program) {
    String name = next();

    return program.procs.link(name);
  }

  public B5Scalar nextScalar(B5Program program) {
    String name = next();

    return program.scalars.link(name);
  }

  public String nextToken() {
    if (peekChar() == '`') {
      nextChar(); // ignore '`'

      StringBuilder token = new StringBuilder();

      while (peekChar() != '`') {
        char c = nextChar();

        if (c != '\\') {
          token.append(c);
        }
        else {
          token.append(nextChar());
        }
      }

      nextChar(); // ignore '`'

      return token.toString();
    }

    return next();
  }

  private String next() {
    String symbol = peek();

    if (symbol == null) {
      throw error("expected symbol");
    }

    symbolBuffer = null;

    return symbol;
  }

  private String peek() {
    if (symbolBuffer != null) {
      return symbolBuffer;
    }
    else if (alive) {
      skipVoid();

      if (peekChar() != B5Reader.EOF) {
        StringBuilder symbol = new StringBuilder();

        if (isLetter(peekChar())) {
          symbol.append(nextChar());
        } else {
          throw error("expected letter");
        }

        while (isLetter(peekChar()) || isDigit(peekChar())) {
          symbol.append(nextChar());
        }

        skipVoid();

        symbolBuffer = symbol.toString();

        return symbolBuffer;
      }
    }

    return null;
  }

  public boolean alive() {
    return alive;
  }

  private boolean skipVoid() {
    boolean skipped = false;

    while(skipComment() || skipBlanks()) {
      skipped = true;
    }

    return skipped;
  }

  private boolean skipComment() {
    boolean commentPresent = (peekChar() == '#');

    if (commentPresent) {
      char c;

      do {
        c = nextChar();
      }
      while(c != B5Reader.EOF && c != '\n');
    }

    return commentPresent;
  }

  private boolean skipBlanks() {
    boolean skipped = false;

    while (isBlank(peekChar())) {
      nextChar();
      skipped = true;
    }

    return skipped;
  }

  private static boolean isLetter(char chr) {
    return chr >= 'a' && chr <= 'z' || chr >= 'A' && chr <= 'Z' || chr == '_';
  }

  private static boolean isDigit(char chr) {
    return chr >= '0' && chr <= '9';
  }

  private static boolean isBlank(char chr) {
    return chr == ' ' || chr == '\t' || chr == '\n' || chr == '\r';
  }

  // CHAR LEVEL OPERATIONS

  private char nextChar() {
    char c = peekChar();

    charBuffer = EOF;

    return c;
  }

  private char peekChar() {
    if (charBuffer != EOF) {
      return charBuffer;
    }
    else if (alive) {
      int code;

      try {
        code = reader.read();
      } catch (IOException e) {
        throw error(e, "error reading input");
      }

      if (code != -1) {
        char chr = (char)code;

        if (chr == '\n') {
          line++;
          column = 0;
        }
        else {
          column++;
        }

        charBuffer = chr;

        return chr;
      }
      else {
        alive = false;
      }
    }

    return EOF;
  }

  public B5Exception error(Throwable cause, String message) {
    return new B5Exception(cause, message + " (" + location() + ")");
  }

  public B5Exception error(String message) {
    return new B5Exception(message + " (" + location() + ")");
  }

  private String location() {
    return "Ln " + line + ", Col " + column;
  }

  public static B5Reader fromResource(String name, Class<?> source) {
    InputStream is = source.getResourceAsStream(name);

    if (is == null) {
      throw new B5Exception("resource not found: " + name);
    }

    return new B5Reader(new InputStreamReader(is));
  }

}
