# B5

B5 is an intermediate representation structure and language to create programs that can be compiled into executable code.

The intended use is to be a library that can be used to autogenerate programs using external tools.

The language for representing B5 was designed for debugging and testing purposes and is not optimized for human reading or using in production.

## Origin

B5 was conceived to be the intermediate representation of the [Bm Language](https://github.com/bm-lang) so the structure and features are designed based on the Bm requirements.

## Structure

The structure of B5 was designed to be simple and small so it can be easily generated, analyzed and compiled.

In this section, the schema of a B5 program will be described using [GraphQL](https://graphql.org/learn/schema) notation.

### Program

The root structure in B5 is a _Program_ which contains [Entities](#entity) and must have a [Procedure](#procedure) marked as the entry point.

```graphql
type Program {
  entities: [Entity!]!
  entryPoint: Procedure!
}
```

### Entity

The members of a [Program](#program) are called _Entities_.
All entities have a unique global name and can be referenced
directly from any part of the program.

```graphql
union Entity = Type | Scalar | Procedure
```

#### Type

Are a set of fields and can inherit from another Type.

```graphql
type Field {
  name: String!
  type: Type!
}

type Type {
  fields: [Field!]
  superType: Type
}
```

#### Scalar

Are global variables that are initialized using a sequence of instructions.

```graphql
type Scalar {
  name: String!
  type: Type!
  init: [Instruction!]!
}
```

#### Procedure

Are sequences of instructions that can be invoked receiving arguments.

```graphql
type Parameter {
  name: String!
  type: Type!
}

type Procedure {
  name: String!
  returnType: Type
  parameters: [Parameter!]
  body: [Instruction!]!
}

```

### Instruction

Are the steps of a routine that can be executed in a scope.

```graphql
union Instruction = Block | Call | Debug | Decrement | Declare | Exit | IfElse
                  | Increment | Jump | Loop | Mark | Nop | Put | Return | Set
                  | While
```

### Expressions

Are operations that result in a value.

```graphql
union Expression = Array
                 | BitAnd | BitNot | BitOr | BitXor
                 | BoolAnd | BoolNot | BoolOr
                 | Cast | Fetch | Get | Is | Len | Literal | Null
                 | NumAdd | NumDiv | NumMod | NumSub
                 | Object | Ref
                 | RelEq | RelGt | RelGte | RelLt | RelLte | RelNeq
```

## Language

The grammar of the language will be descirbed using following notation:

* The equal symbol `=` declares a grammar rule.
* Literal text is delimited using double quotes (`"`).
* Elements between `[]` can be omited.
* Elements between `{}` can be repeated.
* The colon symbol `:` separates the description of the rule reference.

Global rules:

```ebnf
Text = (*
         A letter (a-z, A-Z) followed by more letters, digits (0-9) or underscores (_),
         or a string delimited by grave accents (`)
       *);
```

### Program Syntax

```ebnf
Program = { Type | Scalar | Proc };
```

### Type Syntax

```ebnf
Field = Field-Name:Text "AS" Field-Type:Text;

Type = "TYPE" Type-Name:Text
       [ "EXTENDS" Super-Type:Text ]
       [ "FIELDS" Field { "," Field } ];
```

### Scalar Syntax

```ebnf
Scalar = "SCALAR" Scalar-Name:Text
         "AS" Scalar-Type:Text
         "INIT" Block;
```

### Procedure Syntax

```ebnf
Parameter = Param-Name:Text "AS" Param-Type:Text;

Procedure = "PROC" Proc-Name:Text [ "MAIN" ]
            [ "PARAMS" Parameter { "," Parameter } ]
            [ "RETURNS" Return-Type ]
            "BODY" Instruction;
```

### Instruction Syntax

```ebnf
Instruction = Block | Declare | ...;
```

#### Block Syntax

```ebnf
Block = "BEGIN" { Instruction } "END";
```

#### Declare Syntax

```ebnf
Declare = "DECLARE" Var-Name:Text
          "AS" Var-Type:Text
          "WITH" Initial-Value:Expression;
```

#### Set Syntax

Sets to the reference the specified expression.

```ebnf
Set = "SET" Reference "VALUE" Expression;
```

#### If-Else Syntax

```ebnf
IfElse = "IF" Condition:Expression
         "THEN" Instruction
         [ "ELSE" Instruction ];
```

#### Loop Syntax

```ebnf
Loop = "LOOP" Instruction;
```

#### While Syntax

```ebnf
While = "WHILE" Condition:Expression "DO" Instruction;
```

#### Mark Syntax

```ebnf
Mark = "MARK" Mark-Name:Text;
```

#### Jump Syntax

```ebnf
Jump = "JUMP" Mark-Name:Text;
```

#### Call Syntax

```ebnf
Call = "CALL" Proc-Name:Text
       [ "ARGS" Argument:Expression { "," Argument:Expression } ];
```

#### Return Syntax

```ebnf
Return = "RETURN" Expression;
```

#### Exit Syntax

```ebnf
Exit = "EXIT";
```

#### Put Syntax

```ebnf
Put = "PUT" Array:Expression
      "INDEX" Index:Expression
      "VALUE" Value:Expression;
```

#### Increment Syntax

```ebnf
Increment = "INC" Reference;
```

#### Decrement Syntax

```ebnf
Decrement = "DEC" Reference;
```

### Expression Syntax

```ebnf
Expression = Null | ... ;
```

#### Null Syntax

```ebnf
Null = "NULL";
```

#### Reference Syntax

```ebnf
Reference = "REF" Path-Item:Text { "." Path-Item:Text };
```

#### Object Syntax

```ebnf
Object = "OBJECT" Type-Name:Text;
```

#### Array Syntax

```ebnf
Array = "ARRAY" Size:Expression;
```

#### Literal Syntax

```ebnf
Literal = "LITERAL" Value:Text "AS" Type:Text;
```

#### Is Syntax

```ebnf
Is = "IS" Value:Expression "OF" Type:Text;
```

#### Fetch Syntax

```ebnf
Fetch = "FETCH" Proc-Name
        "ARGS" Argument:Expression { "," Argument:Expression };
```

#### Length Sytnax

```ebnf
Length = "LEN" Array:Expression;
```

#### Get Syntax

```ebnf
Get = "GET" Array:Expression "INDEX" Index:Expression;
```

#### Logical Operators

```ebnf
And = "AND" Left:Expression "," Right:Expression;
Or  = "OR"  Left:Expression "," Right:Expression;
Not = "NOT" Value:Expression;
```

#### Arithmetic Operators

```ebnf
Add = "ADD" Left:Expression "," Right:Expression;
Sub = "SUB" Left:Expression "," Right:Expression;
Mul = "MUL" Left:Expression "," Right:Expression;
Div = "DIV" Left:Expression "," Right:Expression;
Mod = "MOD" Left:Expression "," Right:Expression;
```

#### Relational Operators

```ebnf
Equal       = "EQ"  Left:Expression "," Right:Expression;
NotEqual    = "NEQ" Left:Expression "," Right:Expression;
GreaterThan = "GT"  Left:Expression "," Right:Expression;
LessThan    = "LT"  Left:Expression "," Right:Expression;
GEqualThan  = "GTE" Left:Expression "," Right:Expression;
LEqualThan  = "LTE" Left:Expression "," Right:Expression;
```

#### Bitwise Operators

```ebnf
BitwiseAnd = "BWA" Left:Expression "," Right:Expression;
BitwiseOr  = "BWO" Left:Expression "," Right:Expression;
BitwiseXor = "BWX" Left:Expression "," Right:Expression;
BitwiseNot = "BWN" Left:Expression "," Right:Expression;
```

## Built-in Types

All programs in B5 have always available the following built-in types:

| Name      | Description
| --------- | -----------
| `any`     | Any value.
| `int8`    | 8 bits signed integer number.
| `int16`   | 16 bits signed integer number.
| `int32`   | 32 bits signed integer number.
| `int64`   | 64 bits signed integer number.
| `uint8`   | 8 bits unsigned integer number.
| `uint16`  | 16 bits unsigned integer number.
| `uint32`  | 32 bits unsigned integer number.
| `uint64`  | 64 bits unsigned integer number.
| `float32` | 32 bits floating-point number.
| `float64` | 64 bits floating-point number.
| `bool`    | 8 bits boolean.
| `char`    | 16 bits unicode character.
| `array`   | Dynamic size array.

## Status of the Project

This project is: **In Development**.

B5 is being developed together with the Bm Language.

Tasks:

* [ ] Implement in the runtime missing instructions and expressions.
* [ ] Implement in the design missing instructions and expressions.
* [ ] Make program formatting to match the spec.
* [ ] Reuse logic in the parsing.
