package org.bm.b5.compiling.c;

import org.bm.b5.B5;
import org.bm.b5.B5NamedElement;
import org.bm.b5.entities.B5Type;

import java.util.HashMap;

public class CNameManager {

  private final HashMap<B5NamedElement, String> elems;
  private final HashMap<String, B5NamedElement> names; // TODO check if it can be converted to HashSet

  private int nextId;

  public CNameManager() {
    elems = new HashMap<>();
    names = new HashMap<>();
    nextId = 0;
  }

  public String name(B5NamedElement element) {
    if (element instanceof B5Type) {
      B5Type type = (B5Type)element;

      if (type.name.equals(B5.INT32)) {
        return "int";
      }
    }

    if (elems.containsKey(element)) {
      return elems.get(element);
    }

    String name0 = normalize(element.name);
    String name = name0;

    while (names.containsKey(name)) {
      name = name0 + Integer.toHexString(nextId++);
    }

    names.put(name, element);
    elems.put(element, name);

    return name;
  }

  private static String normalize(String name) {
    // TODO apply transformations and validations to be a valid C name
    return name;
  }

}
