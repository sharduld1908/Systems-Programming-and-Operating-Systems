%{
#include <stdio.h>
int characters,words,sentences;
%}

%%

\n {sentences++;characters--;}
[^ \n\t]+ {words++, characters=characters+yyleng;}
. ;

%%

int yywrap() {
    return 1;
}

int main(int argc,char* argv[]) {
    yyin = fopen(argv[1],"r");
    yylex();
    fclose(yyin);

    printf("The no. of lines in the file = %d",sentences);
    printf("\nThe no. of words in the file = %d",words);
    printf("\nThe no. of characters in the file = %d",characters);
    return 0;
}

