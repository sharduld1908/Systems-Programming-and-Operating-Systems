%{
#include<stdio.h>
void yyerror(char*);
int yylex();
FILE* yyin;
%}

%token ID SC INT CHR FLT BOL BOLVL CHRVL REAL NUM AS COMMA NL

%%	
s: type1|type2|type3|type4;	
type1: INT varlist1 SC NL {printf("Valid Variable Declaration");return 0;};
type2: FLT varlist2 SC NL {printf("Valid Variable Declaration");return 0;};
type3: CHR varlist3 SC NL {printf("Valid Variable Declaration");return 0;};
type4: BOL varlist4 SC NL {printf("Valid Variable Declaration");return 0;};

varlist1: ID | ID COMMA varlist1 | ID AS NUM | ID AS NUM COMMA varlist1;
varlist2: ID | ID COMMA varlist2 | ID AS REAL | ID AS REAL COMMA varlist2;
varlist3: ID | ID COMMA varlist3 | ID AS CHRVL | ID AS CHRVL COMMA varlist3;
varlist4: ID | ID COMMA varlist4 | ID AS BOLVL | ID AS BOLVL COMMA varlist4;
%%

void yyerror(char *s) {
	fprintf(stderr, "ERROR: %s\n",s);
}

int main() {
	yyin = fopen("input.txt","r");
	yyparse();
	fclose(yyin);
	return 0;
}


