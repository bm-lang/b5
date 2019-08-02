package org.bm.b5.runtime.values;

import org.bm.b5.B5Exception;
import org.bm.b5.design.entities.B5Type;
import org.bm.b5.runtime.RValue;

import java.util.HashMap;

public class RObject implements RValue {

  private final B5Type type;

  private final HashMap<String, RValue> fields;

  public RObject(B5Type type) {
    this.type = type;
    this.fields = new HashMap<>();
  }

  @Override
  public RValue get(String member) {
    return fields.get(member);
  }

  @Override
  public void set(String member, RValue value) {
    fields.put(member, value);
  }

  @Override
  public B5Type getType() {
    return type;
  }
}
