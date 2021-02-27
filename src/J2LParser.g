parser grammar J2LParser;

@header {
    import util.*;
}

@members {
    boolean debug = true;

    StringBuffer translation = new StringBuffer ();
    Javadoc jd = new Javadoc(debug);

    public String getTranslation () {
        return translation.toString();
    }
 
    void endCode(Token token) {
        String text = token.getText();

        if (token != null && text.replace("\n", "").trim().length() > 0) {
            writeLine(text);
            writeLine("\\end{lstlisting}");
        }
    }

    void writeLine(Token token) {
        String text = token.getText();
        writeLine(text);
    }

    void writeLine(String text) {
        translation.append(text + "\n");
        System.out.println(text);
    }
}

start
    : (                         { jd = new Javadoc(debug); }
	    jdSection               { translation.append(jd.getTranslation()); }
	    |
	    codeSection
	)*
    eof=EOF                     { endCode($eof); }
;


codeSection
    :                           {writeLine("\\begin{lstlisting}[language=Java]");}
	(
		code=CODE 		        {writeLine($code);}
	)+
;


jdSection 
	: (
		code=JDS        	    { endCode($code); System.out.println("\\begin(jd)\n"); }
		(
			// inline* text=TEXT per commenti inline nella descrizione
		  	text=TEXT   	    { jd.addDescription($text.text); }
		  	|
		  	keyValue
		)*
		keyJDE
	)                           { System.out.print("\\end(jd)\n"); }
;


keyValue
	: (
        key=KEY_PARAM 			{ jd.buffer.setLength(0);}
        inline*
        text=TEXT
    )       					{ jd.addParam(jd.buffer.toString(), $text.text); }
	| (
        key=KEY_EXCEPTION 		{ jd.buffer.setLength(0);}
        inline*
        text=TEXT
    ) 					        { jd.addException(jd.buffer.toString(), $text.text); }
    |
    key=KEY_AUTHOR text=TEXT 	{ jd.addAuthor($text.text); } // TODO: controllare se � un autore o una lista di autori
;


inline
	: before=OPEN_BRACE key=KEY_CODE inline_text=CLOSED_BRACE
	                            { jd.buffer.append($before.text + " \\texttt{" + $inline_text.text + "}");  }
;


keyJDE 
	: (
		key=KEY_PARAM 		    { System.out.print("PARAM " + $key.text); }
		inline*			
		jde=JDE     		    { System.out.print($jde.text + "\n"); }
	)
	|
	(
		key=KEY_EXCEPTION 	    { System.out.println("EXCEPTION " + $key.text); }
		jde=JDE     		    { System.out.println($jde.text + "\n"); }
	)
	|
	(
		key=KEY_AUTHOR 		    { System.out.println("AUTHOR " + $key.text); }
		jde=JDE     		    { System.out.println($jde.text + "\n"); }
	)
	|
	(
		key=KEY_CODE 		    { System.out.println("CODE " + $key.text); }
		jde=JDE     		    { System.out.println($jde.text + "\n"); }
	)	
	|
	text=JDE			        { System.out.println("COMMENT " + $text.text); }
;
