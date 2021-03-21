import org.antlr.runtime.*;
import java.io.*;

%%
%class J2LScanner

%implements TokenSource
%type Token
%public

%line
%column

/* Code in the next section is copied into the generated lexer class. */
%{

  boolean debug = false;

  public StringBuffer string = new StringBuffer();

  public  String getString() {
      return string.toString();
  }

  public Token nextToken() {
      try {
        return yylex();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
  }

  public void setLine(int line) {
      this.yyline = line-1;
  }

  public void setColumn(int column) {
      this.yycolumn = column;
  }

  public int getLine() {
      return this.yyline+1;
  }

  public int getColumn() {
      return this.yycolumn;
  }

  private Token symbol(int type, String text) {
      if(debug) { System.out.println(type + " " + text); }
      CommonToken token = new CommonToken(type, text);
      token.setLine(getLine());
      token.setCharPositionInLine(getColumn());
      return token;
  }

  private Token symbol(int type) {
      if(debug) { System.out.println(type); }
      CommonToken token = new CommonToken(type, yytext());
      token.setLine(getLine());
      token.setCharPositionInLine(getColumn());
      return token;
  }

  @Override
    public String getSourceName() {
      return "JFLEX Scanner";
    }
%}

/* Fragments definition */
LineTerm        = \r|\n|\r\n
WhiteSpace      = [ \t\f]
InputChar       = [^\r\n]

JDWS            = {LineTerm} {WhiteSpace}* "*" {WhiteSpace}*
JDS             = ({LineTerm}* | {WhiteSpace}*) "/**" {WhiteSpace}*
JDE             = {LineTerm}* {WhiteSpace}* "*/" {LineTerm}*
KEY_PARAM       = ("@param") [ \t\f]+
KEY_EXCEPTION   = ("@exception" | "@throws") [ \t\f]+
KEY_AUTHOR      = ("@author") [ \t\f]+
KEY_DEPRECATED  = ("@deprecated") [ \t\f]+
KEY_RETURN  	= ("@return") [ \t\f]+
KEY_CODE        = ("@code") [ \t\f]+
KEY_VERSION     = ("@version") [ \t\f]+
KEY_LINK        = ("@link") [ \t\f]+
KEY_PROVIDES	= ("@provides") [ \t\f]+
KEY_USES		= ("@uses") [ \t\f]+
KEY_SEE			= ("@see") [ \t\f]+
OPEN_BRACE      = "{"
CLOSED_BRACE    = "}"

%states JAVADOC, STRING

%%

// CODE SECTION
<YYINITIAL> {
  // JDS /**
  {JDS}                 {
                            Token token = symbol(sym.JDS, string.toString());
                            string.setLength(0);
                            yybegin(JAVADOC);
                            return token;
                        }

  // STRING
  \"                    {
                            string.append(yytext());
                            yybegin(STRING);
                        }

  // CODE
  {LineTerm}            {
                           Token token = symbol(sym.CODE, string.toString());
                           string.setLength(0);
                           return token;
                        }

  // APPEND
  .                     { string.append(yytext()); }
}


<JAVADOC> {
  // JDE */
  {JDE}                 {
                            Token token = symbol(sym.JDE, string.toString());
                            string.setLength(0);
                            yybegin(YYINITIAL);
                            return token;
                        }

  {KEY_PARAM}           { return symbol(sym.KEY_PARAM, yytext().trim()); }

  {KEY_EXCEPTION}       { return symbol(sym.KEY_EXCEPTION, yytext().trim()); }

  {KEY_AUTHOR}          { return symbol(sym.KEY_AUTHOR, yytext().trim()); }

  {KEY_DEPRECATED}      { return symbol(sym.KEY_DEPRECATED, yytext().trim()); }

  {KEY_RETURN}      	{ return symbol(sym.KEY_RETURN, yytext().trim()); }

  {KEY_VERSION}         { return symbol(sym.KEY_VERSION, yytext().trim()); }

  {KEY_CODE}            { return symbol(sym.KEY_CODE, yytext().trim()); }

  {KEY_LINK}            { return symbol(sym.KEY_LINK, yytext().trim()); }

  {KEY_PROVIDES}		{ return symbol(sym.KEY_PROVIDES, yytext().trim()); }

  {KEY_USES}            { return symbol(sym.KEY_USES, yytext().trim()); }

  {KEY_SEE}				{ return symbol(sym.KEY_SEE, yytext().trim()); }

  {OPEN_BRACE}          {
                            Token token = symbol(sym.OPEN_BRACE, string.toString());
                            string.setLength(0);
                            return token;
                        }

  {CLOSED_BRACE}        {
                            Token token = symbol(sym.CLOSED_BRACE, string.toString());
                            string.setLength(0);
                            return token;
                        }

    {JDWS}                  {
                            Token token = symbol(sym.TEXT, string.toString());
                            string.setLength(0);
                            return token;
                        }

  {LineTerm}            {}

  .                     { string.append(yytext()); }
}


<STRING> {
  \"                    {
                            string.append(yytext());
                            yybegin(YYINITIAL);
                        }
  {WhiteSpace}          { string.append(yytext()); }

  .                     { string.append(yytext()); }
}


<<EOF>>                 {
                            Token token = symbol(sym.EOF, string.toString());
                            string.setLength(0);
                            return token;
                        }

// ERROR
[^]                     { System.out.println("error " + yytext());
                            return symbol(sym.ERROR);
                        }
