package org.bm.b5.compiling.c;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Program;
import org.bm.b5.entities.B5Block;
import org.bm.b5.entities.B5Field;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.entities.B5Type;
import org.bm.b5.instructions.B5Declare;
import org.bm.b5.instructions.B5Instr;

public class CCompiler {

  public static final String[] RESERVED_NAMES = {
      "malloc",
  };

  private final CWriter writer;
  private final CNameManager names;
  private final CElementCheck renderedElements;

  public CCompiler(CWriter writer) {
    this.writer = writer;
    this.names = new CNameManager();
    this.renderedElements = new CElementCheck();
  }

  public void compile(B5Program program) {
    for (B5Type type : program.types) {
      renderType(type);
    }
    
    for (B5Proc proc : program.procs) {
      reanderProc(proc);
    }
  }

  private void reanderProc(B5Proc proc) {
    if (renderedElements.register(proc)) {
      String procName = names.name(proc);
      String returnType;

      if (proc.returnType != null) {
        returnType = names.name((proc.returnType));
      }
      else {
        returnType = "void";
      }

      writer.beginFunction(procName, returnType);
      writer.beginParameters();
      writer.endParameters();
      renderBlock(proc.body);
      writer.endFunction();
    }
  }

  private void renderBlock(B5Block block) {
    writer.beginBlock();

    for (B5Instr instr : block) {
      renderInstr(instr);
    }

    writer.endBlock();
  }

  private void renderInstr(B5Instr instr) {
    if (instr instanceof B5Declare) {
      renderInstrDeclare((B5Declare)instr);
    }
    else {
      throw new B5Exception("instruction not implemented: " + instr);
    }
  }

  private void renderInstrDeclare(B5Declare declare) {
    String typeName = names.name(declare.type);
    String refName = declare.name;

    writer.writeVarDef(typeName, refName);
  }

  private void renderType(B5Type type) {
    if (renderedElements.register(type)) {
      String typeName = names.name(type);

      writer.openStruct(typeName);

      for (B5Type superType : type.superTypes) {
        writer.comment("Inherited from " + superType.name);

        for (B5Field field : superType.fields) {
          renderField(field);
        }
      }

      if (type.superTypes.notEmpty()) {
        writer.comment("New fields for " + type.name);
      }

      for (B5Field field : type.fields) {
        renderField(field);
      }

      writer.closeStruct();
    }
  }

  private void renderField(B5Field field) {
    String fieldName = names.name(field);
    String fieldType = names.name(field.type);

    writer.structField(fieldName, fieldType);
  }

}
