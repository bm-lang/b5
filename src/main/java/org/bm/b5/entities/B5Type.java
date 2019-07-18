package org.bm.b5.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.B5Linkable;
import org.bm.b5.B5Program;
import org.bm.b5.collections.B5TypeFields;

public class B5Type extends B5Entity {

  public final String name;
  public final B5TypeFields fields;

  public B5Type superType;
  public boolean defined;
  public boolean isNative;

  public B5Type(B5Program program, String name) {
    super(program, name);
    this.name = name;
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

  @Override
  public void checkTypes() {
    // TODO detect cyclic dependencies
    fields.checkTypesAll();
  }

  public boolean accepts(B5Type type) {
    if (this == program.typeAny) {
      return true;
    }

    for (B5Type t = type; t != null; t = t.superType) {
      if (t == this) {
        return true;
      }
    }

    return false;
  }

  public static B5Type getCommonType(B5Type type1, B5Type type2) {
    for (B5Type t1 = type1; t1 != null; t1 = t1.superType) {
      for (B5Type t2 = type2; t2 != null; t2 = t2.superType) {
        if (t1 == t2) {
          return t1;
        }
      }
    }

    return null;
  }

  @Override
  public String toString() {
    return "Type:" + name;
  }
}
