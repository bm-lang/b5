package org.bm.b5.formatting;

import org.bm.b5.B5Exception;
import org.bm.b5.design.instructions.*;

public class FInstr {
  public static void write(FWriter writer, B5Instr instr) {
    if (instr instanceof B5Call) {
      writeCall(writer, (B5Call)instr);
    }
    else if (instr instanceof B5Debug) {
      writeDebug(writer, (B5Debug)instr);
    }
    else if (instr instanceof B5Declare) {
      writeDeclare(writer, (B5Declare)instr);
    }
    else if (instr instanceof B5Exit) {
      writeExit(writer, (B5Exit)instr);
    }
    else if (instr instanceof B5IfElse) {
      writeIfElse(writer, (B5IfElse)instr);
    }
    else if (instr instanceof B5Jump) {
      writeJump(writer, (B5Jump)instr);
    }
    else if (instr instanceof B5Loop) {
      writeLoop(writer, (B5Loop)instr);
    }
    else if (instr instanceof B5Mark) {
      writeMark(writer, (B5Mark)instr);
    }
    else if (instr instanceof B5Nop) {
      writeNop(writer, (B5Nop)instr);
    }
    else if (instr instanceof B5Put) {
      writePut(writer, (B5Put)instr);
    }
    else if (instr instanceof B5Return) {
      writeReturn(writer, (B5Return)instr);
    }
    else if (instr instanceof B5Set) {
      writeSet(writer, (B5Set)instr);
    }
    else {
      throw new B5Exception("unknown instr: " + instr);
    }
  }

  private static void writeSet(FWriter writer, B5Set set) {

  }

  private static void writeReturn(FWriter writer, B5Return ret) {

  }

  private static void writePut(FWriter writer, B5Put put) {

  }

  private static void writeNop(FWriter writer, B5Nop nop) {

  }

  private static void writeMark(FWriter writer, B5Mark mark) {

  }

  private static void writeLoop(FWriter writer, B5Loop loop) {

  }

  private static void writeJump(FWriter writer, B5Jump jump) {

  }

  private static void writeIfElse(FWriter writer, B5IfElse ifElse) {

  }

  private static void writeExit(FWriter writer, B5Exit exit) {

  }

  private static void writeDeclare(FWriter writer, B5Declare declare) {

  }

  private static void writeDebug(FWriter writer, B5Debug debug) {

  }

  private static void writeCall(FWriter writer, B5Call call) {

  }
}
