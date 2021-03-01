parser grammar J2LParser;

@header {
    import util.*;
}

@members {
    boolean debug = false;

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
		code=JDS        		{ endCode($code); System.out.println("\\begin(jd)\n"); }
		(
			description=TEXT	{ jd.addDescription($description.text); }
		)*	
		(
			// inline* text=TEXT per commenti inline nella descrizione
		  	keyValue		  	
		)*
		jde=JDE		    { jd.addLastLine($jde.text); }
	)                           { System.out.print("\\end(jd)\n"); }
;


keyValue
	: (
	        key=KEY_PARAM 			{ jd.buffer.setLength(0);}
	        (
	            inline
	            |
	            text=TEXT			{ jd.buffer.append($text.text + " "); }
	        )*	
	    )       				{ jd.addParam(jd.buffer.toString()); }
	| 
	  (
	        key=KEY_EXCEPTION 		{ jd.buffer.setLength(0);}
	        (
	            inline
	            |
	            text=TEXT			{ jd.buffer.append($text.text + " "); }
	        )*	
	  ) 					{ jd.addException(jd.buffer.toString()); }
    |
    key=KEY_AUTHOR text=TEXT 			{ jd.addAuthor($text.text); } // TODO: controllare se � un autore o una lista di autori
;


inline
	: before=OPEN_BRACE key=KEY_CODE inline_text=CLOSED_BRACE
	                            { 
	                           	if (jd.buffer.toString().isEmpty() && $before.text.length() <= 1)  {
	                           		// TODO: gestire errore	
	                           		System.out.println("ERROR: undeclared parameter.");
	                           	}
	                            	else {
	                            		jd.buffer.append($before.text + "\\texttt{" + $inline_text.text + "} ");  
	                            	}
	                            }
;

/**
 * Returns an Image object that 2*2 can then be painted on the screen.
 *
 * @param url  an absolute URL giving the base location of the {@code image} lorenzo@param.it  name the location of the image
 * eskere {@code fuck} cammello
 * prova {@code piscia} cavallo {@code sniffotutto}
 * @param Lorenzo Conti					KEY_PARAM, TEXT, INLINE, JDE 
 * ciaooo {@code ultimissimo} ciao
 */

keyJDE 
	: (
	        key=KEY_PARAM	 		{ jd.buffer.setLength(0);}
	        (
	            inline
	            |
	            text=TEXT			{ jd.buffer.append($text.text + " "); }
	        )*	
	        jde=JDE				{ jd.buffer.append($jde.text); }
	  )       				{ jd.addParam(jd.buffer.toString()); }
	| 
	  (
	        key=KEY_EXCEPTION 		{ jd.buffer.setLength(0);}
	        (
	            inline
	            |
	            text=TEXT			{ jd.buffer.append($text.text + " "); }
	        )*	
	        jde=JDE				{ jd.buffer.append($jde.text); }
	  ) 					{ jd.addException(jd.buffer.toString()); }
	|
	key=KEY_AUTHOR text=TEXT 			{ jd.addAuthor($text.text); } 
	|
	text=JDE			        { System.out.println("COMMENT " + $text.text); }
;