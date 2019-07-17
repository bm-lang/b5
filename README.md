# B5

B5 is an intermediate representation and language to create programs that can be compiled into executable code.

## Entities

### Scalars

Represents a globally accessible variable that is initialized once.

```
SCALAR scalar_name AS type_name
INIT
  instruction_1
  ...
  instruction_n
END
```

### Types

Represents a structure of fields which can extend other types.

```
TYPE type_name
EXTENDS type_name_1
FIELD field_name_1 AS type_name
...
FIELD field_name_n AS type_name
END
```

### Procs

Represents invocable blocks of code that can receive parameters and return a value.

```
PROC procedure_name

PARAM param_name_1 AS type_name
...
PARAM param_name_n AS type_name
MAIN
RETURNS type_name
BODY
  instruction_1
  ...
  instruction_n
END
```

## Instructions

### Variables

```
DECLARE ref_name AS type_name
```

Sets to the reference the specified expression.

```
SET ref_name VALUE expression
```

### Conditional

```
IF expression THEN
  instruction_1
  ...
  instruction_n
ELSE
  instruction_1
  ...
  instruction_n
END
```

### Loops

```
LOOP loop_name
BLOCK

END
```

```
BREAK loop_name
```

### Jumps

```
MARK mark_name
```

```
JUMP mark_name
```

### Call

```
CALL procedure_name
ARG expression_1
...
ARG expression_n
END
```

### Exit & Return

Exits the current procedure returning the specified value.

```
RETURN expression
```

Exits the current procedure without returning a value.

```
EXIT
```

### Array

```
PUT array:expr INDEX expression VALUE expression
```

## Expressions

### References

Reference to a value.

```
REF ref_name END
```

Reference to a value inside another value.

```
REF ref_name_1 PICK ref_name2 PICK ref_name_n END
```

### Instantiation

Generates a reference to a new allocated structure of the specified type.

```
NEW type_name
```

Generates a reference to a new allocated array of the specified size and type.

```
ARRAY size_expression
```

Generates a reference to the specified literal as type.

```
LITERAL literal AS type_name
```

Generates a `bool` indicating if the expression is compatible with the indicated type.

```
IS expression OF type_name
```

### Logical Operators

Generates `true` when the expression is `false`, and `false` when the expression is `true`.

```
NOT expression
```

```
AND expression_1 WITH expression_2
```

```
OR expression_1 WITH expression_2
```

### Arithmetic Operators

```
ADD expression_1 WITH expression_2
SUB
MUL
DIV
MOD
INC
DEC
```

### Relational Operators

Allow to compare two expressions of the same data type category.
All relational operators take 2 arguments and return a `bool` value.

| Syntax                          | Name                      |
| ------------------------------- | ------------------------- |
| `EQ right:expr WITH left:expr`  | Equal (=)                 |
| `NEQ right:expr WITH left:expr` | Not Equal (≠)             |
| `GT right:expr WITH left:expr`  | Greater than (>)          |
| `LT right:expr WITH left:expr`  | Less than (<)             |
| `GTE right:expr WITH left:expr` | Greater than or equal (≥) |
| `LTE right:expr WITH left:expr` | Less than or equal (≤)    |

Compatibility between data type categories.

| Data Type | Number | Boolean | Character
| --------- | ------ | ------- | ---------
| Number    | ✅ | ❌ | ❌ |
| Boolean   | ❌ | ✅ | ❌ |
| Character | ❌ | ❌ | ✅ |

### Bitwise Operators

Allow to perform operations at bit level.
All bitwise operators take 2 arguments and return an _Integer_ value.

| Syntax                          | Name
| ------------------------------- | ----
| `BAN right:expr WITH left:expr` | Conjunction (∧)
| `BOR right:expr WITH left:expr` | Disjunction (∨)
| `XOR right:expr WITH left:expr` | Exclusive Disjunction (⊻)
| `NEG right:expr WITH left:expr` | Complement (¬)
| `SHL right:expr WITH left:expr` | Shift to the left
| `SHR right:expr WITH left:expr` | Shift to the right


### Invocation

Calls the indicated procedure with the arguments and returns the result.

```
FETCH procedure_name ARG expression_1 ... ARG expression_n END
```

### Array Access

Returns an `uint32` representing the number of items that the array can hold.

```
LEN array_ref
```

Returns the value stored at the index location in the array.

```
GET array_ref INDEX expression
```

## Data Types

| Name      | Size    | Categories                |
| --------- | ------- | ------------------------- |
| `int8`    | 8 bits  | Number, Integer, Signed   |
| `int16`   | 16 bits | Number, Integer, Signed   |
| `int32`   | 32 bits | Number, Integer, Signed   |
| `int64`   | 64 bits | Number, Integer, Signed   |
| `uint8`   | 8 bits  | Number, Integer, Unsigned |
| `uint16`  | 16 bits | Number, Integer, Unsigned |
| `uint32`  | 32 bits | Number, Integer, Unsigned |
| `uint64`  | 64 bits | Number, Integer, Unsigned |
| `float32` | 32 bits | Number, Float             |
| `float64` | 64 bits | Number, Float             |
| `bool`    | 8 bits  | Boolean                   |
| `char`    | 16 bits | Character                 |
| `array`   | ---     | Array                     |
