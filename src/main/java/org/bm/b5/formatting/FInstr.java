package org.bm.b5.formatting;

import org.bm.b5.B5Exception;
import org.bm.b5.design.instructions.*;
import org.bm.b5.parsing.B5Lang;

public class FInstr {
  public static void write(FWriter writer, B5Instr instr) {
    B5Instr curr = instr;

    do {
      if (curr instanceof B5Block) {
        writeBlock(writer, (B5Block) curr);
      } else if (curr instanceof B5Call) {
        writeCall(writer, (B5Call) curr);
      } else if (curr instanceof B5Debug) {
        writeDebug(writer, (B5Debug) curr);
      } else if (curr instanceof B5Declare) {
        writeDeclare(writer, (B5Declare) curr);
      } else if (curr instanceof B5Exit) {
        writeExit(writer, (B5Exit) curr);
      } else if (curr instanceof B5IfElse) {
        writeIfElse(writer, (B5IfElse) curr);
      } else if (curr instanceof B5Jump) {
        writeJump(writer, (B5Jump) curr);
      } else if (curr instanceof B5Loop) {
        writeLoop(writer, (B5Loop) curr);
      } else if (curr instanceof B5Mark) {
        writeMark(writer, (B5Mark) curr);
      } else if (curr instanceof B5Nop) {
        writeNop(writer, (B5Nop) curr);
      } else if (curr instanceof B5Put) {
        writePut(writer, (B5Put) curr);
      } else if (curr instanceof B5Return) {
        writeReturn(writer, (B5Return) curr);
      } else if (curr instanceof B5Set) {
        writeSet(writer, (B5Set) curr);
      } else {
        throw new B5Exception("unknown instr: " + curr);
      }

      writer.spacing();

      curr = curr.next;
    }
    while(curr != null);
  }

  private static void writeBlock(FWriter writer, B5Block block) {
    writer.writeLine(B5Lang.BEGIN);
    FInstr.write(writer, block.instr);
    writer.write(B5Lang.END);
  }

  private static void writeCall(FWriter writer, B5Call call) {
    writer.write(B5Lang.CALL);
    writer.write(call.proc.name);
    if (call.args.size() > 0) {
      writer.writeLine();
      writer.write(B5Lang.ARGS);
      writer.writeList(call.args, arg -> {
        FExpr.write(writer, arg);
      });
    }
  }

  private static void writeDebug(FWriter writer, B5Debug debug) {
    writer.write(B5Lang.DEBUG);
    writer.write(debug.output);
  }

  private static void writeDeclare(FWriter writer, B5Declare declare) {
    writer.write(B5Lang.DECLARE);
    writer.write(declare.name);
    writer.write(B5Lang.AS);
    writer.write(declare.type.name);
    writer.writeLine();
    writer.write(B5Lang.WITH);
    FExpr.write(writer, declare.value);
  }

  private static void writeExit(FWriter writer, B5Exit exit) {
    writer.write(B5Lang.EXIT);
  }

  private static void writeIfElse(FWriter writer, B5IfElse ifElse) {
    writer.write(B5Lang.IF);
    FExpr.write(writer, ifElse.condition);
    writer.writeLine();
    writer.write(B5Lang.THEN);
    FInstr.write(writer, ifElse.thenInstr);
    if (ifElse.elseInstr != null) {
      writer.writeLine();
      writer.write(B5Lang.ELSE);
      FInstr.write(writer, ifElse.elseInstr);
    }
  }

  private static void writeJump(FWriter writer, B5Jump jump) {
    writer.write(B5Lang.JUMP);
    writer.write((jump.markName));
  }

  private static void writeLoop(FWriter writer, B5Loop loop) {
    writer.write(B5Lang.LOOP);
    FInstr.write(writer, loop.instr);
  }

  private static void writeMark(FWriter writer, B5Mark mark) {
    writer.write(B5Lang.MARK);
    writer.write(mark.name);
  }

  private static void writeNop(FWriter writer, B5Nop nop) {
    writer.write(B5Lang.NOP);
  }

  private static void writePut(FWriter writer, B5Put put) {
    writer.write(B5Lang.PUT);
    FExpr.write(writer, put.array);
    writer.write(B5Lang.INDEX);
    FExpr.write(writer, put.index);
    writer.write(B5Lang.VALUE);
    FExpr.write(writer, put.value);
  }

  private static void writeReturn(FWriter writer, B5Return ret) {
    writer.write(B5Lang.RETURN);
    FExpr.write(writer, ret.value);
  }

  private static void writeSet(FWriter writer, B5Set set) {
    writer.write(B5Lang.SET);
    FExpr.writeRef(writer, set.ref);
    writer.write(B5Lang.VALUE);
    FExpr.write(writer, set.value);
  }
}
