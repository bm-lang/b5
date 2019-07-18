package org.bm.b5.design.entities;

import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5NamedElement;

public class B5Field extends B5NamedElement implements B5Linkable {

  public final B5Type parent;
  public final B5Type type;

  public B5Field(B5Type parentType, String fieldName, B5Type fieldType) {
    super(fieldName);
    this.parent = parentType;
    this.type = fieldType;
  }

  @Override
  public void checkDefinition() {

  }

  @Override
  public void checkTypes() {

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
}
