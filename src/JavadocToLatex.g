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

            translation.append(text);
            translation.append("\\end(code)\n");

            System.out.print(text);
            System.out.print("\n\\end(code)\n");
        }
    }


    void writeLine(Token token) {

        String text = token.getText();
        writeLine(text);
    }

    void writeLine(String text) {

        translation.append(text);
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
	    { writeLine("\\begin(code)\n"); }

	    (
	        code=CODE { writeLine($code); }
	    )+
	;

jdSection
	:
	(
	code=JDS        {
                        endCode($code);
                        System.out.println("\\begin(jd)\n");
		            }
	  (
	  	text=TEXT   { System.out.println($text.text + "\n"); }
	  	|
	  	keyValue
	  )*
	  (
	    key=KEY     { System.out.println($key.text); }) ?
	    jde=JDE     { System.out.println($jde.text + "\n"); }
	  )

	  { System.out.print("\\end(jd)\n"); }
	;

keyValue
	: key=KEY text=TEXT { System.out.print($key.text + " " + $text.text); }
	;



 



	




