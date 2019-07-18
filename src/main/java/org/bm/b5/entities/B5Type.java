package org.bm.b5.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Linkable;
import org.bm.b5.B5Program;
import org.bm.b5.collections.B5TypeFields;
import org.bm.b5.collections.B5SuperTypes;

public class B5Type extends B5Entity {

  public final String name;
  public final B5SuperTypes superTypes;
  public final B5TypeFields fields;

  public boolean defined;

  public B5Type(B5Program program, String name) {
    super(program, name);
    this.name = name;
    this.superTypes = new B5SuperTypes(this);
    this.fields = new B5TypeFields(this);
  }

  public B5Linkable findField(String fieldName) {
    B5Field field = fields.get(fieldName);

    if (field == null) {
      throw new B5Exception("type " + name + " doesn't have a field named " + fieldName);
    }

    return field;
  }

  @Override
  public void checkDefinition() {
    if (!defined) {
      throw new B5Exception("the type " + name + " is not defined");
    }
  }

}
