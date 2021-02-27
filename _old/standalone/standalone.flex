%%
%class Standalone
%standalone
%line
%column

/* Code in the next section is copied into the generated lexer class. */
%{
  public StringBuffer string = new StringBuffer();

  public  String getString() {
      return string.toString();
  }

  private Integer symbol(Integer type) {
    System.out.println("Type: " + type.toString());
    return type;
  }
  private Integer symbol(Integer state, Integer type, Object value) {
    System.out.println("State: " + state.toString() + "\t Type: " + type.toString() + "\t Text: " + value.toString());
    return type;
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
                    Integer token = symbol(yystate(), 0, string.toString());
                    string.setLength(0);
                    yybegin(JAVADOC);
                    return token;
                  }

  \"              {
                    string.append(yytext());
                    yybegin(STRING);
                  }

   {WhiteSpace} {string.append(yytext()); }

   {LineTerm}    {
          string.append(yytext());
          Integer token = symbol(yystate(), 1, string.toString());
          string.setLength(0);
          return token;
      }

  .               { string.append(yytext()); }

}

<JAVADOC> {

  {JDE}             {

                        Integer token = symbol(yystate(), 2, string.toString());
                        string.setLength(0);
                        yybegin(YYINITIAL);
                        return token;

                    }

  {JDKV}           {
                        return symbol(yystate(), 3, yytext().trim());
                        //return symbol(yystate(), 2, yytext().trim());
                    }

  {JDKD}           {
                        return symbol(yystate(), 4, yytext().trim());
                    }

  {JDWS}          {
                    Integer token = symbol(yystate(), 5, string.toString());
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
                    return 6;
                    }


