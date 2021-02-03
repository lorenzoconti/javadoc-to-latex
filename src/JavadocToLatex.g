parser grammar JavadocToLatex;


start : ( 
	{System.out.println("\\begin(jd)\n");} jdSection  {System.out.println("\\end(jd)\n");}
	| 		
	{System.out.println("\\begin(code)\n");} cs=codeSection {System.out.println("\\end(code)\n");} )* eof=EOF { System.out.println($eof.text + "\n"); };

codeSection
	: (code=CODE{ System.out.println($code.text + "\n"); })+
	;

jdSection
	: 
	( 
	code=JDS { if ($code != null){
			System.out.println($code.text + "\n"); 			
		 }
		}
	  ( 
	  	text=TEXT { System.out.println($text.text + "\n"); }
	  	| 
	  	keyValue 
	  )* 
	  (key=KEY  { System.out.println($key.text + "\n"); }) ?
	  jde=JDE   { System.out.println($jde.text + "\n"); }
	  )
	;

keyValue
	: key=KEY text=TEXT { System.out.println($key.text + " " + $text.text); }
	;



 



	




