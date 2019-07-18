package org.bm.b5;

import org.bm.b5.collections.B5ProgramProcs;
import org.bm.b5.collections.B5ProgramScalars;
import org.bm.b5.collections.B5ProgramTypes;
import org.bm.b5.entities.B5Block;
import org.bm.b5.entities.B5Proc;
import org.bm.b5.entities.B5Scalar;
import org.bm.b5.entities.B5Type;

import java.util.Objects;

public class B5Program extends B5Element implements B5Scope {

  public final B5ProgramTypes types;
  public final B5ProgramScalars scalars;
  public final B5ProgramProcs procs;

  public B5Proc main;

  // Native Types:
  public final B5Type typeAny;
  public final B5Type typeInt32;
  public final B5Type typeArray;
  public final B5Type typeBool;

  public B5Program() {
    types = new B5ProgramTypes(this);
    scalars = new B5ProgramScalars(this);
    procs = new B5ProgramProcs(this);

    typeInt32 = createNativeType(this, B5.INT32);
    typeAny = createNativeType(this, B5.ANY);
    typeArray = createNativeType(this, B5.ARRAY);
    typeBool = createNativeType(this, B5.BOOL);
  }

  private B5Type createNativeType(B5Program program, String name) {
    B5Type type = program.types.create(name);
    type.defined = true;
    type.isNative = true;
    return type;
  }

  public void checkDefinition() {
    types.checkDefinitionAll();
    scalars.checkDefinitionAll();
    procs.checkDefinitionAll();
  }

  public void linkReferences() {
    for (B5Scalar scalar : scalars) {
      scalar.linkReferences();
    }

    for (B5Proc proc : procs) {
      proc.linkReferences();
    }
  }

  @Override
  public B5Linkable findLinkable(String name) {
    for (B5Scalar scalar : scalars) {
      if (Objects.equals(name, scalar.getName())) {
        return scalar;
      }
    }

    throw new B5Exception("program doesn't have a scalar named: " + name);
  }

  public B5Type findBiggestIntegerType(B5Type left, B5Type right) {
    if (left == typeInt32) {
      if (right == typeInt32) {
        return typeInt32;
      }
    }

    // TODO add more cases

    throw new B5Exception("cannot find biggest integer in: " + left + " and " + right);
  }

  public B5Type findBiggestNumberType(B5Type left, B5Type right) {
    if (left == typeInt32) {
      if (right == typeInt32) {
        return typeInt32;
      }
    }

    // TODO add more cases

    throw new B5Exception("cannot find biggest integer in: " + left + " and " + right);
  }

  @Override
  public B5Block getContextBlock() {
    return null;
  }

  @Override
  public B5Program getProgram() {
    return this;
  }
}
