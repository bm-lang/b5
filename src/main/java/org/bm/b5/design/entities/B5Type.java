package org.bm.b5.design.entities;

import org.bm.b5.B5Exception;
import org.bm.b5.design.B5Linkable;
import org.bm.b5.design.B5Program;
import org.bm.b5.design.collections.B5TypeFields;

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
  public void link() {

  }

  @Override
  public void compile() {
    if (!defined) {
      throw new B5Exception("the type " + name + " is not defined");
    }

    fields.compileAll();

    // TODO detect cyclic dependencies
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

  @Override
  public String toString() {
    return "Type:" + name;
  }
}
