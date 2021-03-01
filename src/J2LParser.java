// $ANTLR 3.5.1 D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g 2021-03-01 19:11:51

    import util.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class J2LParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CLOSED_BRACE", "CODE", "JDE", 
		"JDS", "KEY_AUTHOR", "KEY_CODE", "KEY_EXCEPTION", "KEY_PARAM", "OPEN_BRACE", 
		"TEXT"
	};
	public static final int EOF=-1;
	public static final int CLOSED_BRACE=4;
	public static final int CODE=5;
	public static final int JDE=6;
	public static final int JDS=7;
	public static final int KEY_AUTHOR=8;
	public static final int KEY_CODE=9;
	public static final int KEY_EXCEPTION=10;
	public static final int KEY_PARAM=11;
	public static final int OPEN_BRACE=12;
	public static final int TEXT=13;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public J2LParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public J2LParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return J2LParser.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g"; }


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



	// $ANTLR start "start"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:37:1: start : ( jdSection | codeSection )* eof= EOF ;
	public final void start() throws RecognitionException {
		Token eof=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:38:5: ( ( jdSection | codeSection )* eof= EOF )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:38:7: ( jdSection | codeSection )* eof= EOF
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:38:7: ( jdSection | codeSection )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==JDS) ) {
					alt1=1;
				}
				else if ( (LA1_0==CODE) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:38:33: jdSection
					{
					 jd = new Javadoc(debug); 
					pushFollow(FOLLOW_jdSection_in_start61);
					jdSection();
					state._fsp--;

					 translation.append(jd.getTranslation()); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:41:6: codeSection
					{
					pushFollow(FOLLOW_codeSection_in_start91);
					codeSection();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			eof=(Token)match(input,EOF,FOLLOW_EOF_in_start103); 
			 endCode(eof); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "start"



	// $ANTLR start "codeSection"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:47:1: codeSection : (code= CODE )+ ;
	public final void codeSection() throws RecognitionException {
		Token code=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:48:5: ( (code= CODE )+ )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:48:33: (code= CODE )+
			{
			writeLine("\\begin{lstlisting}[language=Java]");
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:49:2: (code= CODE )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==CODE) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:50:3: code= CODE
					{
					code=(Token)match(input,CODE,FOLLOW_CODE_in_codeSection174); 
					writeLine(code);
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "codeSection"



	// $ANTLR start "jdSection"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:55:1: jdSection : (code= JDS (description= TEXT )* ( keyValue )* jde= JDE ) ;
	public final void jdSection() throws RecognitionException {
		Token code=null;
		Token description=null;
		Token jde=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:56:2: ( (code= JDS (description= TEXT )* ( keyValue )* jde= JDE ) )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:56:4: (code= JDS (description= TEXT )* ( keyValue )* jde= JDE )
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:56:4: (code= JDS (description= TEXT )* ( keyValue )* jde= JDE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:57:3: code= JDS (description= TEXT )* ( keyValue )* jde= JDE
			{
			code=(Token)match(input,JDS,FOLLOW_JDS_in_jdSection208); 
			 endCode(code); System.out.println("\\begin(jd)\n"); 
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:58:3: (description= TEXT )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==TEXT) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:59:4: description= TEXT
					{
					description=(Token)match(input,TEXT,FOLLOW_TEXT_in_jdSection230); 
					 jd.addDescription((description!=null?description.getText():null)); 
					}
					break;

				default :
					break loop3;
				}
			}

			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:61:3: ( keyValue )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==KEY_AUTHOR||(LA4_0 >= KEY_EXCEPTION && LA4_0 <= KEY_PARAM)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:63:6: keyValue
					{
					pushFollow(FOLLOW_keyValue_in_jdSection253);
					keyValue();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			jde=(Token)match(input,JDE,FOLLOW_JDE_in_jdSection269); 
			 jd.addLastLine((jde!=null?jde.getText():null)); 
			}

			 System.out.print("\\end(jd)\n"); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "jdSection"



	// $ANTLR start "keyValue"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:70:1: keyValue : ( (key= KEY_PARAM ( inline |text= TEXT )+ ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* ) |key= KEY_AUTHOR text= TEXT );
	public final void keyValue() throws RecognitionException {
		Token key=null;
		Token text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:71:2: ( (key= KEY_PARAM ( inline |text= TEXT )+ ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* ) |key= KEY_AUTHOR text= TEXT )
			int alt7=3;
			switch ( input.LA(1) ) {
			case KEY_PARAM:
				{
				alt7=1;
				}
				break;
			case KEY_EXCEPTION:
				{
				alt7=2;
				}
				break;
			case KEY_AUTHOR:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:71:4: (key= KEY_PARAM ( inline |text= TEXT )+ )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:71:4: (key= KEY_PARAM ( inline |text= TEXT )+ )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:72:10: key= KEY_PARAM ( inline |text= TEXT )+
					{
					key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyValue331); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:73:10: ( inline |text= TEXT )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=3;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==OPEN_BRACE) ) {
							alt5=1;
						}
						else if ( (LA5_0==TEXT) ) {
							alt5=2;
						}

						switch (alt5) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:74:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue362);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:76:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue394); 
							 jd.buffer.append((text!=null?text.getText():null) + " "); 
							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					}

					 jd.addParam(jd.buffer.toString()); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:80:4: (key= KEY_EXCEPTION ( inline |text= TEXT )* )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:80:4: (key= KEY_EXCEPTION ( inline |text= TEXT )* )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:81:10: key= KEY_EXCEPTION ( inline |text= TEXT )*
					{
					key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyValue452); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:82:10: ( inline |text= TEXT )*
					loop6:
					while (true) {
						int alt6=3;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==OPEN_BRACE) ) {
							alt6=1;
						}
						else if ( (LA6_0==TEXT) ) {
							alt6=2;
						}

						switch (alt6) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:83:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue482);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:85:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue514); 
							 jd.buffer.append((text!=null?text.getText():null) + " "); 
							}
							break;

						default :
							break loop6;
						}
					}

					}

					 jd.addException(jd.buffer.toString()); 
					}
					break;
				case 3 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:89:5: key= KEY_AUTHOR text= TEXT
					{
					key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyValue555); 
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue559); 
					 jd.addAuthor((text!=null?text.getText():null)); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "keyValue"



	// $ANTLR start "inline"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:93:1: inline : before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE ;
	public final void inline() throws RecognitionException {
		Token before=null;
		Token key=null;
		Token inline_text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:94:2: (before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:94:4: before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE
			{
			before=(Token)match(input,OPEN_BRACE,FOLLOW_OPEN_BRACE_in_inline578); 
			key=(Token)match(input,KEY_CODE,FOLLOW_KEY_CODE_in_inline582); 
			inline_text=(Token)match(input,CLOSED_BRACE,FOLLOW_CLOSED_BRACE_in_inline586); 
			 
				                           	if (jd.buffer.toString().isEmpty() && (before!=null?before.getText():null).length() <= 1)  {
				                           		// TODO: gestire errore	
				                           		System.out.println("ERROR: undeclared parameter.");
				                           	}
				                            	else {
				                            		jd.buffer.append((before!=null?before.getText():null) + "\\texttt{" + (inline_text!=null?inline_text.getText():null) + "} ");  
				                            	}
				                            
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inline"



	// $ANTLR start "keyJDE"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:116:1: keyJDE : ( (key= KEY_PARAM ( inline |text= TEXT )* jde= JDE ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* jde= JDE ) |key= KEY_AUTHOR text= TEXT |text= JDE );
	public final void keyJDE() throws RecognitionException {
		Token key=null;
		Token text=null;
		Token jde=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:117:2: ( (key= KEY_PARAM ( inline |text= TEXT )* jde= JDE ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* jde= JDE ) |key= KEY_AUTHOR text= TEXT |text= JDE )
			int alt10=4;
			switch ( input.LA(1) ) {
			case KEY_PARAM:
				{
				alt10=1;
				}
				break;
			case KEY_EXCEPTION:
				{
				alt10=2;
				}
				break;
			case KEY_AUTHOR:
				{
				alt10=3;
				}
				break;
			case JDE:
				{
				alt10=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:117:4: (key= KEY_PARAM ( inline |text= TEXT )* jde= JDE )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:117:4: (key= KEY_PARAM ( inline |text= TEXT )* jde= JDE )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:118:10: key= KEY_PARAM ( inline |text= TEXT )* jde= JDE
					{
					key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyJDE644); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:119:10: ( inline |text= TEXT )*
					loop8:
					while (true) {
						int alt8=3;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==OPEN_BRACE) ) {
							alt8=1;
						}
						else if ( (LA8_0==TEXT) ) {
							alt8=2;
						}

						switch (alt8) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:120:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyJDE675);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:122:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyJDE707); 
							 jd.buffer.append((text!=null?text.getText():null) + " "); 
							}
							break;

						default :
							break loop8;
						}
					}

					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE737); 
					 jd.buffer.append((jde!=null?jde.getText():null)); 
					}

					 jd.addParam(jd.buffer.toString()); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:127:4: (key= KEY_EXCEPTION ( inline |text= TEXT )* jde= JDE )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:127:4: (key= KEY_EXCEPTION ( inline |text= TEXT )* jde= JDE )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:128:10: key= KEY_EXCEPTION ( inline |text= TEXT )* jde= JDE
					{
					key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyJDE781); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:129:10: ( inline |text= TEXT )*
					loop9:
					while (true) {
						int alt9=3;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==OPEN_BRACE) ) {
							alt9=1;
						}
						else if ( (LA9_0==TEXT) ) {
							alt9=2;
						}

						switch (alt9) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:130:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyJDE811);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:132:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyJDE843); 
							 jd.buffer.append((text!=null?text.getText():null) + " "); 
							}
							break;

						default :
							break loop9;
						}
					}

					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE873); 
					 jd.buffer.append((jde!=null?jde.getText():null)); 
					}

					 jd.addException(jd.buffer.toString()); 
					}
					break;
				case 3 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:137:2: key= KEY_AUTHOR text= TEXT
					{
					key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyJDE898); 
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyJDE902); 
					 jd.addAuthor((text!=null?text.getText():null)); 
					}
					break;
				case 4 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:139:2: text= JDE
					{
					text=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE916); 
					 System.out.println("COMMENT " + (text!=null?text.getText():null)); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "keyJDE"

	// Delegated rules



	public static final BitSet FOLLOW_jdSection_in_start61 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_codeSection_in_start91 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_EOF_in_start103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CODE_in_codeSection174 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_JDS_in_jdSection208 = new BitSet(new long[]{0x0000000000002D40L});
	public static final BitSet FOLLOW_TEXT_in_jdSection230 = new BitSet(new long[]{0x0000000000002D40L});
	public static final BitSet FOLLOW_keyValue_in_jdSection253 = new BitSet(new long[]{0x0000000000000D40L});
	public static final BitSet FOLLOW_JDE_in_jdSection269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyValue331 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_inline_in_keyValue362 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue394 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyValue452 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_inline_in_keyValue482 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue514 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyValue555 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_TEXT_in_keyValue559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_BRACE_in_inline578 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_KEY_CODE_in_inline582 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CLOSED_BRACE_in_inline586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyJDE644 = new BitSet(new long[]{0x0000000000003040L});
	public static final BitSet FOLLOW_inline_in_keyJDE675 = new BitSet(new long[]{0x0000000000003040L});
	public static final BitSet FOLLOW_TEXT_in_keyJDE707 = new BitSet(new long[]{0x0000000000003040L});
	public static final BitSet FOLLOW_JDE_in_keyJDE737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyJDE781 = new BitSet(new long[]{0x0000000000003040L});
	public static final BitSet FOLLOW_inline_in_keyJDE811 = new BitSet(new long[]{0x0000000000003040L});
	public static final BitSet FOLLOW_TEXT_in_keyJDE843 = new BitSet(new long[]{0x0000000000003040L});
	public static final BitSet FOLLOW_JDE_in_keyJDE873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyJDE898 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_TEXT_in_keyJDE902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_JDE_in_keyJDE916 = new BitSet(new long[]{0x0000000000000002L});
}
