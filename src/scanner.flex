///////////////////////////////////
/// Scanner esame 07-02-2006 //////
///////////////////////////////////
import java_cup.runtime.*;
%%
%class Scanner
%cup
%line
%column
numero = [0-9]+
date = ((0[1-9])|([1-2][0-9])|(3(0|1)))"/"((0[1-9])|(1(0|1|2)))"/"(2[0-9][0-9][0-9])
ora = (((0|1)[0-9])|(2[0-3]))":"([0-5][0-9])
canzone = [a-zA-Z][_a-zA-Z0-9]*".mp3"
ip_num = (2(([0-4][0-9])|(5[0-5])))|(1[0-9][0-9])|([1-9][0-9])|([0-9])
ip = {ip_num}"."{ip_num}"."{ip_num}"."{ip_num}

%%
"mp3_list" {return new Symbol(sym.INIZIO, yyline, yycolumn); }
"Kb/s" {return new Symbol(sym.KBS, yyline, yycolumn); }
"server" {return new Symbol(sym.SERVER, yyline, yycolumn); }
"time" {return new Symbol(sym.TIME, yyline, yycolumn); }
"data" {return new Symbol(sym.DATA, yyline, yycolumn); }
";" {return new Symbol(sym.PV, yyline, yycolumn); }
"," {return new Symbol(sym.V, yyline, yycolumn); }
":" {return new Symbol(sym.PP, yyline, yycolumn); }
{ip} {return new Symbol(sym.IP, yyline, yycolumn, new String(yytext())); }
{numero} {return new Symbol(sym.NUMERO, yyline, yycolumn, new Integer(yytext())); }
{canzone} {return new Symbol(sym.CANZONE, yyline, yycolumn, new String(yytext())); }
{date} {return new Symbol(sym.DATE, yyline, yycolumn); }
{ora} {return new Symbol(sym.ORA, yyline, yycolumn); }
[ \n\r\t] {;}