%%
%class Scanner
%standalone
%line
%column

/* Code in the next section is copied into the generated lexer class. */
%{
  StringBuffer string = new StringBuffer();

  private Integer symbol(Integer type) {
    System.out.println("Type: " + type.toString());
    return type;
    // return new Symbol(type, yyline, yycolumn);
  }
  private Integer symbol(Integer state, Integer type, Object value) {
    System.out.println("State: " + state.toString() + "\t Type: " + type.toString() + "\t Text: " + value.toString());
    return type;
    //return new Symbol(type, yyline, yycolumn, value);
  }
%}

/* Fragments definition */
LineTerm        = \r|\n|\r\n
WhiteSpace      = [ \t\f]
InputChar       = [^\r\n]

JDWS            = {LineTerm} {WhiteSpace}* "*" {WhiteSpace}*
JDS             = ({LineTerm}* | {WhiteSpace}*) "/**" {WhiteSpace}*
JDE             = {LineTerm}* {WhiteSpace}* "*/" {LineTerm}*
JDKV            = ("@param" | "@exception" | "@provides" | "@throws" | "@uses" | "@version") [ \t\f]+
JDKD            = ("@author" | "@deprecated" | "@return" | "@serial" | "@serialData" | "@since" | "@see")[ \t\f]+
JDKINLINE       = ("@code" | "@link" | "@linkplain") [ \t\f]+
MD              = "#"+ {InputChar}* LineTerm

%states CODE, STRING

%%

<YYINITIAL> {
  {JDS}             {
                        symbol(yystate(), sym.JDS, "");
                    }
  {JDE}             {
                        symbol(yystate(), sym.JDE, string.toString());
                        string.setLength(0);
                        yybegin(CODE);
                    }

  {JDKV}           { return symbol(yystate(), sym.KEY_VALUE, yytext().trim()); }

  {JDKD}           { return symbol(yystate(), sym.KEY_DESCRIPTION, yytext().trim()); }

  {JDWS}          {
                    Integer token = symbol(yystate(), sym.TEXT, string.toString());
                    string.setLength(0);
                    return token;
                  }
  {LineTerm}     {}

  .               { string.append(yytext()); }
}

<CODE> {

  {JDS}           {
                    Integer token = symbol(yystate(), sym.CODE, string.toString());
                    string.setLength(0);
                    yybegin(YYINITIAL);
                    return token;
                  }

  \"              {
                    //symbol(yystate(), 5, "");
                    string.append(yytext());
                    yybegin(STRING);
                  }

  ({WhiteSpace} | {LineTerm})    { string.append(yytext()); }

  .               { string.append(yytext()); }

  <<EOF>>         {
                    Integer token = symbol(yystate(), sym.CODE, string.toString());
                    string.setLength(0);
                    yybegin(YYINITIAL);
                    return token;
                  }
}

<STRING> {
  \"              {
                    string.append(yytext());
                    yybegin(CODE);
                  }
  {WhiteSpace}    { string.append(yytext()); }
  .               { string.append(yytext()); }
}

/* Error fallback */
[^]               { System.out.println("errore " + yytext()); }
