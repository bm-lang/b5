package org.bm.b5.design.instructions;

import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.entities.B5Block;
import org.bm.b5.design.entities.B5Type;

import java.util.function.Consumer;

public class B5Declare extends B5Instr implements B5Linkable {

  public final String name;
  public final B5Type type;

  public B5Declare(B5Block parent, String name, B5Type type) {
    super(parent);
    this.name = name;
    this.type = type;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

  }

  @Override
  public void linkReferences() {

  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public B5Linkable pick(String member) {
    return type.findField(member);
  }

  @Override
  public B5Type getType() {
    return type;
  }

  @Override
  public void walk(Consumer<B5Instr> consumer) {

  }
}
