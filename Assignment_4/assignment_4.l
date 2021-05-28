%{
#include <stdio.h>
FILE* yyin;
%}

DIGIT [0-9]
NUMBER {DIGIT}*
REAL {NUMBER}+[.]{NUMBER}+
TEXT [A-Za-z]
STRING_CONSTANT "\""[A-Za-z ]*"\""
IMPORT_STATEMENT "import"[^\n]*";"
KEYWORDS "class"|"abstract"|"interface"|"static"|"implements"|"extends"
CONDITIONALS "if"|"else"|"else if"|"switch"|"case"
ITERATIVES "for"|"while"|"do"
DATATYPES "int"|"double"|"float"|"long"|"boolean"|"char"|"byte"|"short"|"String"|"void"
WRAPPERS "Integer"|"Double"|"Float"|"Long"|"Boolean"|"Char"|"Byte"|"Short"
SEMICOLON ";"
ACCESS_OPERATORS "public"|"private"|"protected"
IDENTIFIERS {TEXT}({DIGIT}|{TEXT}|"_")*
ARITHMETIC_OPERATORS "+"|"-"|"*"|"/"|"++"|"--"|"+="|"-="|"*="|"\="|"="
LOGICAL_OPERATORS ">"|"<"|"<="|">="|"=="|"?"|"&&"|"||"|"^"|"!"|"!="
PRINTING_STATEMENT "System.out.println"

%%

[ \n\t]+ ;
"." ;
{IMPORT_STATEMENT} {printf("%s\t ==> IMPORT_STATEMENT\n",yytext);}
{KEYWORDS} {printf("%s\t\t\t ==> KEYWORD\n",yytext);}
{CONDITIONALS} {printf("%s\t\t\t ==> CONDITIONAL\n",yytext);}
{ITERATIVES} {printf("%s\t\t\t ==> ITERATIVE\n",yytext);}
{DATATYPES} {printf("%s\t\t\t ==> DATATYPE\n",yytext);}
{WRAPPERS} {printf("%s\t\t\t ==> WRAPPER\n",yytext);}
{SEMICOLON} {printf("%s\t\t\t ==> SEMICOLON\n",yytext);}
{ACCESS_OPERATORS} {printf("%s\t\t\t ==> ACCESS_OPERATOR\n",yytext);}
{IDENTIFIERS} {printf("%s\t\t\t ==> IDENTIFIER\n",yytext);}
{ARITHMETIC_OPERATORS} {printf("%s\t\t\t ==> ARITHMETIC_OPERATOR\n",yytext);}
{LOGICAL_OPERATORS} {printf("%s\t\t\t ==> LOGICAL_OPERATOR\n",yytext);}
{NUMBER} {printf("%s\t\t\t ==> CONSTANT\n",yytext);}
{REAL} {printf("%s\t\t\t ==> REAL CONSTANT\n",yytext);}
{STRING_CONSTANT} {printf("%s\t ==> STRING_CONSTANT\n",yytext);}
{PRINTING_STATEMENT} {printf("%s\t ==> PRINTING_STATEMENT\n",yytext);}
"(" {printf("%s\t\t\t ==> OPENING BRACKET\n",yytext);}
")" {printf("%s\t\t\t ==> CLOSING BRACKET\n",yytext);}
"{" {printf("%s\t\t\t ==> OPENING BLOCK\n",yytext);}
"}" {printf("%s\t\t\t ==> CLOSING BLOCK\n",yytext);}

%%

int yywrap() {
    return 1;
}

int main(int argc,char* argv[]) {
    yyin = fopen(argv[1],"r");
    yylex();
    fclose(yyin);

    return 0;
}

