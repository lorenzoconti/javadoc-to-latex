import java_cup.runtime.*;

%%
%class Scanner
%cup
%line
%column

/* Code in the next section is copied into the generated lexer class. */
%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(Integer type) {
    System.out.println("Type: " + type.toString());
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(Integer state, Integer type, Object value) {
    System.out.println("State: " + state.toString() + "\t Type: " + type.toString() + "\t Text: " + value.toString());
    return new Symbol(type, yyline, yycolumn, value);
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

%states JAVADOC, STRING

%%

<YYINITIAL> {

  {JDS}           {
                    //Integer token = symbol(yystate(), sym.CODE, string.toString());
                    Symbol token = symbol(yystate(), sym.CODE, string.toString());
                    string.setLength(0);
                    yybegin(JAVADOC);
                    return token;
                  }

  \"              {
                    string.append(yytext());
                    yybegin(STRING);
                  }

  ({WhiteSpace} | {LineTerm})    { string.append(yytext()); }

  .               { string.append(yytext()); }

  <<EOF>>         {
                    //Integer token = symbol(yystate(), sym.CODE, string.toString());
                    Symbol token = symbol(yystate(), sym.EOF, string.toString());
                    string.setLength(0);
                    //yybegin(YYINITIAL);
                    return token;
                  }
}

<JAVADOC> {

  {JDE}             {
                        //symbol(yystate(), sym.JDE, string.toString());
                        Symbol token = symbol(yystate(), sym.TEXT, string.toString());
                        string.setLength(0);
                        yybegin(YYINITIAL);
                        return token;

                    }

  {JDKV}           {
                        return symbol(yystate(), sym.KEY_VALUE, yytext().trim());
                        //return symbol(yystate(), 2, yytext().trim());
                    }

  {JDKD}           {
                        return symbol(yystate(), sym.KEY_VALUE, yytext().trim());
                        //return symbol(yystate(), 3, yytext().trim());
                    }

  {JDWS}          {
                    Symbol token = symbol(yystate(), sym.TEXT, string.toString());
                    //Integer token = symbol(yystate(), 4, string.toString());
                    string.setLength(0);
                    return token;
                  }
  {LineTerm}     {}

  .               { string.append(yytext()); }
}



<STRING> {
  \"              {
                    string.append(yytext());
                    yybegin(YYINITIAL);
                  }
  {WhiteSpace}    { string.append(yytext()); }
  .               { string.append(yytext()); }
}

/* Error fallback */
[^]               { System.out.println("errore " + yytext());
                    return new Symbol(sym.error);
                    }


