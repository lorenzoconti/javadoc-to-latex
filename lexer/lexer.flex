%%
%public
%class Lexer
%unicode
%standalone
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
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

%states CODE, STRING

%%

<YYINITIAL> {
  "/**"           { return newToken(yystate(), 1, yytext()); }
  "*/"            { 
                    newToken(yystate(), 2, yytext());
                    string.setLength(0); 
                    yybegin(CODE); 
                  }
  {WhiteSpace}    { /* ignore */ }
  .               { /* ignore */ }
}

<CODE> {
  "/**"           { 
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