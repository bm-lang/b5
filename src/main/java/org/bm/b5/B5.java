package org.bm.b5;

public class B5 {

  // Built-in type names
  public static final String INT8 = "int8";
  public static final String INT16 = "int16";
  public static final String INT32 = "int32";
  public static final String INT64 = "int64";
  public static final String UINT8 = "uint8";
  public static final String UINT16 = "uint16";
  public static final String UINT32 = "uint32";
  public static final String UINT64 = "uint64";
  public static final String FLOAT32 = "float32";
  public static final String FLOAT64 = "float64";
  public static final String BOOL = "bool";
  public static final String CHAR = "char";
  public static final String ARRAY = "array";

  public static void createNativeTypes(B5Program program) {
    program.types.create(INT32).defined = true;
  }

}
