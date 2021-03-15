// $ANTLR 3.5.1 D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g 2021-03-15 21:45:41

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



	// $ANTLR start "start"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:30:1: start : ( jdSection | codeSection )* eof= EOF ;
	public final void start() throws RecognitionException {
		Token eof=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:30:6: ( ( jdSection | codeSection )* eof= EOF )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:31:5: ( jdSection | codeSection )* eof= EOF
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:31:5: ( jdSection | codeSection )*
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:32:6: jdSection
					{
					pushFollow(FOLLOW_jdSection_in_start62);
					jdSection();
					state._fsp--;

					 translation.append(jd.getTranslation()); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:34:6: codeSection
					{
					pushFollow(FOLLOW_codeSection_in_start93);
					codeSection();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			eof=(Token)match(input,EOF,FOLLOW_EOF_in_start110); 
			 	if (eof != null) c.addCode((eof!=null?eof.getText():null));
			    									translation.append(c.getTranslation()); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:41:1: codeSection : (code= CODE )+ ;
	public final void codeSection() throws RecognitionException {
		Token code=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:41:12: ( (code= CODE )+ )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:41:40: (code= CODE )+
			{
			 c = new Code(debug); 
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:42:2: (code= CODE )+
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:43:3: code= CODE
					{
					code=(Token)match(input,CODE,FOLLOW_CODE_in_codeSection177); 
					 c.addCode((code!=null?code.getText():null)); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:48:1: jdSection : (code= JDS (description= TEXT )* ( keyValue )* jde= JDE ) ;
	public final void jdSection() throws RecognitionException {
		Token code=null;
		Token description=null;
		Token jde=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:48:10: ( (code= JDS (description= TEXT )* ( keyValue )* jde= JDE ) )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:49:3: (code= JDS (description= TEXT )* ( keyValue )* jde= JDE )
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:49:3: (code= JDS (description= TEXT )* ( keyValue )* jde= JDE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:49:12: code= JDS (description= TEXT )* ( keyValue )* jde= JDE
			{
			 	jd = new Javadoc(debug); 
			code=(Token)match(input,JDS,FOLLOW_JDS_in_jdSection215); 
			 	if (code != null) c.addCode((code!=null?code.getText():null));
			    										translation.append(c.getTranslation()); 
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:52:3: (description= TEXT )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==TEXT) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:53:4: description= TEXT
					{
					description=(Token)match(input,TEXT,FOLLOW_TEXT_in_jdSection239); 
					 jd.addDescription((description!=null?description.getText():null)); 
					}
					break;

				default :
					break loop3;
				}
			}

			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:55:3: ( keyValue )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==KEY_AUTHOR||(LA4_0 >= KEY_EXCEPTION && LA4_0 <= KEY_PARAM)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:57:6: keyValue
					{
					pushFollow(FOLLOW_keyValue_in_jdSection264);
					keyValue();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			jde=(Token)match(input,JDE,FOLLOW_JDE_in_jdSection280); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:64:1: keyValue : ( (key= KEY_PARAM ( inline |text= TEXT )* ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* ) | (key= KEY_AUTHOR ( inline |text= TEXT )* ) );
	public final void keyValue() throws RecognitionException {
		Token key=null;
		Token text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:65:2: ( (key= KEY_PARAM ( inline |text= TEXT )* ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* ) | (key= KEY_AUTHOR ( inline |text= TEXT )* ) )
			int alt8=3;
			switch ( input.LA(1) ) {
			case KEY_PARAM:
				{
				alt8=1;
				}
				break;
			case KEY_EXCEPTION:
				{
				alt8=2;
				}
				break;
			case KEY_AUTHOR:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:65:4: (key= KEY_PARAM ( inline |text= TEXT )* )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:65:4: (key= KEY_PARAM ( inline |text= TEXT )* )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:66:10: key= KEY_PARAM ( inline |text= TEXT )*
					{
					key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyValue342); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:67:10: ( inline |text= TEXT )*
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
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:68:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue373);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:70:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue405); 
							 jd.buffer.append((text!=null?text.getText():null) + " "); 
							}
							break;

						default :
							break loop5;
						}
					}

					}

					 jd.addParam(jd.buffer.toString()); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:74:4: (key= KEY_EXCEPTION ( inline |text= TEXT )* )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:74:4: (key= KEY_EXCEPTION ( inline |text= TEXT )* )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:75:10: key= KEY_EXCEPTION ( inline |text= TEXT )*
					{
					key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyValue463); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:76:10: ( inline |text= TEXT )*
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
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:77:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue493);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:79:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue525); 
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:83:8: (key= KEY_AUTHOR ( inline |text= TEXT )* )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:83:8: (key= KEY_AUTHOR ( inline |text= TEXT )* )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:84:13: key= KEY_AUTHOR ( inline |text= TEXT )*
					{
					key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyValue585); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:85:13: ( inline |text= TEXT )*
					loop7:
					while (true) {
						int alt7=3;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==OPEN_BRACE) ) {
							alt7=1;
						}
						else if ( (LA7_0==TEXT) ) {
							alt7=2;
						}

						switch (alt7) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:86:17: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue631);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:88:17: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue669); 
							 jd.buffer.append((text!=null?text.getText():null) + " "); 
							}
							break;

						default :
							break loop7;
						}
					}

					}

					 jd.addAuthor(jd.buffer.toString()); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:95:1: inline : before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE ;
	public final void inline() throws RecognitionException {
		Token before=null;
		Token key=null;
		Token inline_text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:96:2: (before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:96:4: before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE
			{
			before=(Token)match(input,OPEN_BRACE,FOLLOW_OPEN_BRACE_in_inline741); 
			key=(Token)match(input,KEY_CODE,FOLLOW_KEY_CODE_in_inline745); 
			inline_text=(Token)match(input,CLOSED_BRACE,FOLLOW_CLOSED_BRACE_in_inline749); 
			 
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

	// Delegated rules



	public static final BitSet FOLLOW_jdSection_in_start62 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_codeSection_in_start93 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_EOF_in_start110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CODE_in_codeSection177 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_JDS_in_jdSection215 = new BitSet(new long[]{0x0000000000002D40L});
	public static final BitSet FOLLOW_TEXT_in_jdSection239 = new BitSet(new long[]{0x0000000000002D40L});
	public static final BitSet FOLLOW_keyValue_in_jdSection264 = new BitSet(new long[]{0x0000000000000D40L});
	public static final BitSet FOLLOW_JDE_in_jdSection280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyValue342 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_inline_in_keyValue373 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue405 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyValue463 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_inline_in_keyValue493 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue525 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyValue585 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_inline_in_keyValue631 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue669 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_OPEN_BRACE_in_inline741 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_KEY_CODE_in_inline745 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CLOSED_BRACE_in_inline749 = new BitSet(new long[]{0x0000000000000002L});
}
