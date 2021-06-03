### TO RUN THE PROGRAM:
To execute lex program:  lex assignment_4.l

To execute c program:    gcc lex.yy.c

To execute a.out: 	 ./a.out Main.java

### OUTPUT:
import java.util.*;	 ==> IMPORT_STATEMENT

import java.io.*;	 ==> IMPORT_STATEMENT

class			 ==> KEYWORD

Main			 ==> IDENTIFIER

{			 ==> OPENING BLOCK

private			 ==> ACCESS_OPERATOR

String			 ==> DATATYPE

s			 ==> IDENTIFIER

;			 ==> SEMICOLON

public			 ==> ACCESS_OPERATOR

int			 ==> DATATYPE

i			 ==> IDENTIFIER

;			 ==> SEMICOLON

protected		 ==> ACCESS_OPERATOR

double			 ==> DATATYPE

db			 ==> IDENTIFIER

;			 ==> SEMICOLON

public			 ==> ACCESS_OPERATOR

static			 ==> KEYWORD

void			 ==> DATATYPE

main			 ==> IDENTIFIER

(			 ==> OPENING BRACKET

String			 ==> DATATYPE

[]args			 ==> IDENTIFIER

)			 ==> CLOSING BRACKET

{			 ==> OPENING BLOCK

s			 ==> IDENTIFIER

=			 ==> ARITHMETIC_OPERATOR

"I am Shardul"	 	 ==> STRING_CONSTANT

;			 ==> SEMICOLON

i			 ==> IDENTIFIER

=			 ==> ARITHMETIC_OPERATOR

21			 ==> CONSTANT

;			 ==> SEMICOLON

db			 ==> IDENTIFIER

=			 ==> ARITHMETIC_OPERATOR

79.97			 ==> REAL CONSTANT

;			 ==> SEMICOLON

System.out.println	 ==> PRINTING_STATEMENT

(			 ==> OPENING BRACKET

"Hi "	 		 ==> STRING_CONSTANT

\+			 ==> ARITHMETIC_OPERATOR

s			 ==> IDENTIFIER

)			 ==> CLOSING BRACKET

;			 ==> SEMICOLON

if			 ==> CONDITIONAL

(			 ==> OPENING BRACKET

db			 ==> IDENTIFIER

>			 ==> LOGICAL_OPERATOR
>			 
50			 ==> CONSTANT

)			 ==> CLOSING BRACKET

{			 ==> OPENING BLOCK

System.out.println	 ==> PRINTING_STATEMENT

(			 ==> OPENING BRACKET

"db is greater than
 50 & db = "	 	 ==> STRING_CONSTANT
 
+			 ==> ARITHMETIC_OPERATOR
	 
db			 ==> IDENTIFIER

)			 ==> CLOSING BRACKET

;			 ==> SEMICOLON

}			 ==> CLOSING BLOCK

else if			 ==> CONDITIONAL

(			 ==> OPENING BRACKET

db			 ==> IDENTIFIER

==			 ==> LOGICAL_OPERATOR

50			 ==> CONSTANT

)			 ==> CLOSING BRACKET

{			 ==> OPENING BLOCK

System.out.println	 ==> PRINTING_STATEMENT

(			 ==> OPENING BRACKET

"db is equal to 50
 & db = "	 	 ==> STRING_CONSTANT
 
+			 ==> ARITHMETIC_OPERATOR

db			 ==> IDENTIFIER

)			 ==> CLOSING BRACKET

;			 ==> SEMICOLON

}			 ==> CLOSING BLOCK

else			 ==> CONDITIONAL

{			 ==> OPENING BLOCK

System.out.println	 ==> PRINTING_STATEMENT

(			 ==> OPENING BRACKET

"db is lesser than
 50 & db = "	 	 ==> STRING_CONSTANT
 
+			 ==> ARITHMETIC_OPERATOR

db			 ==> IDENTIFIER

)			 ==> CLOSING BRACKET

;			 ==> SEMICOLON

}			 ==> CLOSING BLOCK

for			 ==> ITERATIVE

(			 ==> OPENING BRACKET

int			 ==> DATATYPE

j			 ==> IDENTIFIER

=			 ==> ARITHMETIC_OPERATOR

0			 ==> CONSTANT

;			 ==> SEMICOLON

j			 ==> IDENTIFIER

<			 ==> LOGICAL_OPERATOR

i			 ==> IDENTIFIER

;			 ==> SEMICOLON

++			 ==> ARITHMETIC_OPERATOR

j			 ==> IDENTIFIER

)			 ==> CLOSING BRACKET

{			 ==> OPENING BLOCK

System.out.println	 ==> PRINTING_STATEMENT

(			 ==> OPENING BRACKET

"j = "	 		 ==> STRING_CONSTANT

+			 ==> ARITHMETIC_OPERATOR

j			 ==> IDENTIFIER

)			 ==> CLOSING BRACKET

;			 ==> SEMICOLON

}			 ==> CLOSING BLOCK

}			 ==> CLOSING BLOCK

}			 ==> CLOSING BLOCK
