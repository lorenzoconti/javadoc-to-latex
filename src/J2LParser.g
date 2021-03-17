parser grammar J2LParser;

@header {
    import util.*;
}

@members {
    boolean debug = false;

    StringBuffer translation = new StringBuffer ();
    Javadoc jd = new Javadoc(debug);
    Code c = new Code(debug);	
	
    public String getTranslation () {
        return translation.toString();
    }
 
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
      	
		String msg = getErrorMessage(e, tokenNames);    
		String capmsg = msg.substring(0, 1).toUpperCase() + msg.substring(1); 
		
		System.err.println(
		"JavadocToLatex Parser ERROR at line " + e.line + " and column " + e.charPositionInLine + ".\n" 
		+ capmsg);
	
	}
}

start: 
    	(                         		
	    	jdSection               	{ translation.append(jd.getTranslation()); }
	    	|
	    	codeSection					
		)*
    	eof=EOF                     	{ 	if ($eof != null) c.addCode($eof.text);
    									translation.append(c.getTranslation()); }
;


codeSection:                          	{ c = new Code(debug); }
		(
			code=CODE 						{ c.addCode($code.text); }
		)+
;


jdSection:
		(								{ 	jd = new Javadoc(debug); }
			code=JDS        			{ 	if ($code != null) c.addCode($code.text);
    										translation.append(c.getTranslation()); }
    									{ jd.buffer.setLength(0);}
		(
			description=TEXT			{ jd.buffer.append($description.text); }
			|
			inline
		)*								{ jd.addDescription(jd.buffer.toString());}
		(
		  	keyValue		  	
		)*
		jde=JDE		    				{ jd.addLastLine($jde); }
	)
;


keyValue
	: (
		key=KEY_PARAM			{ jd.buffer.setLength(0);}
		(
			inline
			|
			text=TEXT			{ jd.buffer.append($text.text); }
		)*
	)							{ jd.addParam(jd.buffer.toString()); }
	|
     (
		key=KEY_EXCEPTION		{ jd.buffer.setLength(0);}
		(
			inline
			|
			text=TEXT			{ jd.buffer.append($text.text); }
		)*
	)							{ jd.addException(jd.buffer.toString()); }
	|
	(
		key=KEY_AUTHOR			{ jd.buffer.setLength(0);}
		(
			inline
			|
			text=TEXT			{ jd.buffer.append($text.text); }
		)*
	)							{ jd.addAuthor(jd.buffer.toString()); }
	|
	(
		key=KEY_VERSION			{ jd.buffer.setLength(0);}
		(
		text=TEXT				{ jd.buffer.append($text.text); }
		)?
	)							{ jd.addVersion(jd.buffer.toString()); }
;

// @param {@code }

inline:	(
			before=OPEN_BRACE key=KEY_CODE inline_text=CLOSED_BRACE
		)
		{ jd.addInlineCode($before.text, $key, $inline_text.text); }
		
;

