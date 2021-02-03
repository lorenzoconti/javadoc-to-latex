parser grammar JavadocToLatex;


start : ( jdSection | codeSection)* eof=EOF { System.out.println($eof + "\n"); };

codeSection
	: (code=CODE{ System.out.println($code + "\n"); })+
	;

jdSection
	: 
	( 
	code=JDS { System.out.println($code + "\n"); }
	  ( 
	  	text=TEXT { System.out.println($text + "\n"); }
	  	| 
	  	keyValue 
	  )* 
	  key=KEY?   { System.out.println($key + "\n"); }
	  jde=JDE   { System.out.println($jde + "\n"); }
	  )
	;

keyValue
	: key=KEY text=TEXT { System.out.println($key + " " + $text); }
	;



 



	




