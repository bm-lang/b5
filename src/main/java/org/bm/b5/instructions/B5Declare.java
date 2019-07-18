package org.bm.b5.instructions;

import org.bm.b5.B5Linkable;
import org.bm.b5.entities.B5Block;
import org.bm.b5.entities.B5Type;

public class B5Declare extends B5Instr implements B5Linkable {

  public final String name;
  public final B5Type type;

  public B5Declare(B5Block parent, String name, B5Type type) {
    super(parent);
    this.name = name;
    this.type = type;
  }

  @Override
  public void check() {

  }

  @Override
  public void link() {

  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public B5Linkable pick(String member) {
    return type.findField(member);
  }
}
