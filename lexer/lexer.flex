import java_cup.runtime.Symbol;

// import java_cup.runtime.ComplexSymbolFactory;
// import java_cup.runtime.ComplexSymbolFactory.Location;

%%
%public
%class Lexer
%unicode
// %standalone 
%cup
%line
%column

/* Code in the next section is copied into the generated lexer class. */
%{
  StringBuffer string = new StringBuffer();

  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int state, int type, Object value) {
    // System.out.println("State: " + state.toString() + "\t Type: " + type.toString() + "\t Text: " + value.toString());
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

/* Fragments definition */
LineTerm        = \r|\n|\r\n
WhiteSpace      = {LineTerm} | [ \t\f]
InputChar       = [^\r\n]

JDWS            = {WhiteSpace}* "*" {WhiteSpace}*
JDLine          = {JDWS} {InputChar}* {LineTerm}
JDS             = "/**"
JDE             = "*/"
JDK             = ("@param" | "@author") [ \t\f]+ /* TODO: complete with all tokens */
MD              = "#"+ {InputChar}* LineTerm

%states CODE, STRING

%%

<YYINITIAL> {
  {JDS}           { return symbol(yystate(), sym.SEMI, yytext()); }
  {JDE}           { 
                    symbol(yystate(), 2, yytext());
                    string.setLength(0); 
                    yybegin(CODE); 
                  }
  {JDK}           { return symbol(yystate(), 5, yytext().trim()); }
  {JDWS}          { 
                    Symbol token = symbol(yystate(), 3, string.toString()); 
                    string.setLength(0); 
                    return token;
                  }
  .               { string.append(yytext()); }
}

<CODE> {
  {JDS}           { 
                    yybegin(YYINITIAL);
                    string.append(yytext()); 
                    return symbol(yystate(), 1, string.toString()); 
                  }
  \"              { 
                    symbol(yystate(), 2, yytext());
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

<<EOF>>           { return symbol(yystate(), 10, ""); }

/* error fallback */
[^]               { System.out.println("errore " + yytext()); }