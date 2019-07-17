package org.bm.b5.collections;

import org.bm.b5.collections.B5List;
import org.bm.b5.collections.B5Set;
import org.bm.b5.entities.B5Field;
import org.bm.b5.entities.B5Type;

public class B5TypeFields extends B5Set<B5Field> {

  private final B5Type type;

  public B5TypeFields(B5Type type) {
    this.type = type;
  }

  public void add(String fieldName, B5Type fieldType) {
    add(new B5Field(type, fieldName, fieldType));
  }
}
