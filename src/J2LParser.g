parser grammar J2LParser;

@header {
    import util.*;
}

@members {
    boolean debug = false;
    boolean exitFromCodeSection = true;

    StringBuffer translation = new StringBuffer ();
    Javadoc jd = new Javadoc(debug);

    public String getTranslation () {
        return translation.toString();
    }
 
    void endCode(Token token) {
        String text = token.getText();
        
        System.out.println(text);

        if (token != null && exitFromCodeSection) {
            writeLine(text);
            writeLine("\\end{lstlisting}");
            exitFromCodeSection = false;
        }
    } 
		/** aaaaaaaaaaaaaa 
	*/
    void writeLine(Token token) {
        String text = token.getText();
        writeLine(text); 
    }

    void writeLine(String text) {
        translation.append(text + "\n");
        if (debug) { System.out.println(text);}
    }
    
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
      	
	String msg = getErrorMessage(e, tokenNames);    
	String capmsg = msg.substring(0, 1).toUpperCase() + msg.substring(1); 
	
	System.err.println(
	"JavadocToLatex Parser ERROR at line " + e.line + " and column " + e.charPositionInLine + ".\n" 
	+ capmsg);
	
	// JavadocToLatex Parser ERROR at line: 30:21 required (...)+ loop did not match anything at input 'Lorenzo'
    }
    
    // error
}

start
    : (                         //{ jd = new Javadoc(debug); }
	    jdSection               { translation.append(jd.getTranslation()); }
	    |
	    codeSection
	)*
    eof=EOF                     { endCode($eof); }
;


codeSection
    :                           {writeLine("\\begin{lstlisting}[language=Java]"); exitFromCodeSection=true;}
	(
		code=CODE 		        {writeLine($code); }
	)+
;


jdSection 
	: (					{ jd = new Javadoc(debug); }
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
    	  (
            key=KEY_AUTHOR             { jd.buffer.setLength(0);}
            (
                inline
                |
                text=TEXT            { jd.buffer.append($text.text + " "); }
            )*
      )                     { jd.addAuthor(jd.buffer.toString()); }
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

