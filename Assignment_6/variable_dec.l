%{
#include <stdio.h>
#include "y.tab.h"
%}

DIGIT [0-9]
REAL {DIGIT}+[.]{DIGIT}+
LETTER [A-Za-z]
NUMBER {DIGIT}+
ASSIGN =

%%

[\t ] ;
int {return (INT);}
float {return (FLT);}
char {return (CHR);}
boolean {return (BOL);}
true|false {return (BOLVL);}
['][^\t\n]['] {return (CHRVL);}
{REAL} {return (REAL);}
{NUMBER} {return (NUM);}
[a-zA-Z]+[a-zA-Z0-9_]* {return(ID);}
"," {return (COMMA);}
";" {return (SC);}
{ASSIGN} {return (AS);}
\n {return (NL);}
. ;

%%

int yywrap() {
return 1;
}
