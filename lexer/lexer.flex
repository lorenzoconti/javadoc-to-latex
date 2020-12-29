%%
%public
%class Lexer
%unicode
%standalone /* TODO: change to %cup */
%line
%column

/* Code in the next section is copied into the generated lexer class. */
%{
  StringBuffer string = new StringBuffer();

  private int newToken(Integer state, Integer type, String text) {
    System.out.println("State: " + state.toString() + "\t Type: " + type.toString() + "\t Text: " + text);
    return type;
  }
%}

/* Fragments definition */
LineTerm        = \r|\n|\r\n
WhiteSpace      = {LineTerm} | [ \t\f]
InputChar       = [^\r\n]

JDWS            = {WhiteSpace}* "*" {WhiteSpace}*
JDS             = "/**"
JDE             = "*/"
JDK             = "@param" | "@author" /* TODO: complete with all tokens */
MD              = "#"+ {InputChar}* LineTerm

%states CODE, STRING

%%

<YYINITIAL> {
  {JDS}           { return newToken(yystate(), 1, yytext()); }
  {JDE}           { 
                    newToken(yystate(), 2, yytext());
                    string.setLength(0); 
                    yybegin(CODE); 
                  }
  {JDWS}          { /* ignore */ }
  .               { /* ignore */ }
}

<CODE> {
  {JDS}           { 
                    yybegin(YYINITIAL);
                    string.append(yytext()); 
                    return newToken(yystate(), 1, string.toString()); 
                  }
  \"              { 
                    newToken(yystate(), 2, yytext());
                    string.append(yytext());
                    yybegin(STRING); 
                  }
  {WhiteSpace}    { string.append(yytext()); }
  .               { string.append(yytext()); }
}

<STRING> {
  \"              { 
                    string.append(yytext()); 
                    yybegin(CODE); 
                  }
  {WhiteSpace}    { string.append(yytext()); }
  .               { string.append(yytext()); }
}

<<EOF>>           { return newToken(yystate(), 10, ""); }

/* error fallback */
[^]               { System.out.println("errore " + yytext()); }