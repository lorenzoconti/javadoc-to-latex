parser grammar JavadocToLatex;

@header {
}

@members {
    StringBuffer translation = new StringBuffer ();

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

start : (
	    jdSection
	    |
	    cs=codeSection
	    )*
	    eof=EOF { endCode($eof); }
        ;


codeSection 
	: 
	
	{writeLine("\\begin{lstlisting}[language=Java]");}
	
	(
		code=CODE 		{writeLine($code);}
	 )+
	;
	

jdSection 
	:	
		
	(
		code=JDS        	{ endCode($code);
				  	  System.out.println("\\begin(jd)\n");
		            		}
		(
		  	text=TEXT   	{ System.out.println($text.text + "\n"); }
		  	|
		  	keyValue
		)*
		
		keyJDE
	) 
	  

	{ System.out.print("\\end(jd)\n"); }
	;
	

keyValue
	: 
		key=KEY_PARAM 	text=TEXT 	{ System.out.print("PARAM " + $key.text + " " + $text.text); }
	| 
		key=KEY_EXCEPTION text=TEXT 	{ System.out.print("EXCEPTION " + $key.text + " " + $text.text); }
	| 
		key=KEY_AUTHOR 	text=TEXT 	{ System.out.print("AUTHOR " + $key.text + " " + $text.text); }
	| 
		key=KEY_CODE text=TEXT		{ System.out.print("CODE " + $key.text + " " + $text.text); }
	;
	
keyJDE 
	:
	(
		(key=KEY_PARAM 		{ System.out.println("PARAM " + $key.text); }) ?
		jde=JDE     		{ System.out.println($jde.text + "\n"); }
	) 
	|
	(
		(key=KEY_EXCEPTION 	{ System.out.println("EXCEPTION " + $key.text); }) ?
		jde=JDE     		{ System.out.println($jde.text + "\n"); }
	)
	|
	(
		(key=KEY_AUTHOR 	{ System.out.println("AUTHOR " + $key.text); }) ?
		jde=JDE     		{ System.out.println($jde.text + "\n"); }
	)
	|
	(
		(key=KEY_CODE 		{ System.out.println("CODE " + $key.text); }) ?
		jde=JDE     		{ System.out.println($jde.text + "\n"); }
	)	
	;





	




