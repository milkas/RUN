grammar Script;

@header{parser;}

file: (functionDeclaration | expression | varDeclaration)+;

functionDeclaration
    : 'function' WS? functionName WS? '(' functionParameters? ')' WS? functionBody
    ;

functionName
    : ID
    ;
functionParameters
    : functionParameter (',' functionParameter)*
    ;
functionParameter
    : ID
    ;

functionBody
    : '{' (functionDeclaration | expression | varDeclaration)* '}'
    ;

expression
    : functionCall #functionCallExpression
    | createInstance #createInstanceExpression
    | thisExpression #thisExpressionExpression
    | messageToInstance #messageToInstanceExpression
    | arrayAccess #arrayAccessExpression
    | ifStatement #ifExpression
    | whileStatement #whileExpression
    | TRUE #true
    | FALSE #false
    | ID #id
    | INT #int
    | DOUBLE #double
    | STRING #string
    | arrayAssignment #arrayAssignmentExpression
    | createArray #array
    | prototypeAssignmentExpression #prototypeAssignmentExpressionExpression
    | assignmentExpression #assignmentExpressionExpression
    | anonymousFunction #anonymousFunctionExpression
    | '(' expression ')' #parenthesesExpression
    | '!' expression #notExpression
    | '-' expression #unaryMinusExpression
    | expression MUL expression #mulExpression
    | expression DIV expression #divExpression
    | expression MOD expression #modExpression
    | expression PLUS expression #plusExpression
    | expression MINUS expression #minusExpression
    | expression COMPARE_OPERATORS expression #compareExpression
    | expression '==' expression #equalsExpression
    | expression AND expression #andExpression
    | expression OR expression #orExpression
    ;

functionCall
    : ID '(' callParams? ')'
    ;
callParams
    : callParam (',' callParam)*
    ;
callParam
    : (ID|INT|STRING|DOUBLE)
    ;

createInstance
    : 'new' ID'(' callParams? ')'
    ;

messageToInstance
    : ID'.'ID'(' callParams? ')' #callMethodOnInstance
    | ID'.'ID ASSIGNMENT expression  #setPropertyOnInstance
    | ID'.'ID  #getPropertyOnInstance
    ;

thisExpression
    : 'this.'ID'(' callParams? ')' #thisCallMethod
    | 'this.'ID ASSIGNMENT expression #thisSetterExpression
    | 'this.'ID #thisGetterExpression
    ;

prototypeAssignmentExpression
    :   ID'.prototype' ASSIGNMENT expression #prototypeAssignment
    ;

assignmentExpression
    :   ID ASSIGNMENT expression #assignment
    |   'var' ID ASSIGNMENT expression #varAssignment
    ;

anonymousFunction
    : 'function' '(' functionParameters? ')' functionBody
    ;

varDeclaration
    : 'var' ID
    ;

createArray
    : '[' callParams? ']'
    ;
arrayAssignment
    : ID'[' callParams? ']' ASSIGNMENT expression
    ;
arrayAccess
    : ID'[' callParams? ']'
    ;

ifStatement
    : 'if''('expression')' functionBody 'else' functionBody
    ;

whileStatement
    : 'while''('expression')' functionBody
    ;

ASSIGNMENT:'=';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
MOD: '%';
AND: '&&';
OR: '||';
INT: '-'? [0-9]+;
DOUBLE: '-'? [0-9]+ ','? [0-9]+;
TRUE: 'true';
FALSE: 'false';
COMPARE_OPERATORS
    : '<'
    | '>'
    ;
ID: [a-zA-Z$_][a-zA-Z0-9$_]*;
STRING: '"' [a-zA-Z0-9,./?!+-*$_]* '"';
WS: [ \t\r\n]+ -> skip;
COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
