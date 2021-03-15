// $ANTLR 3.5.1 D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g 2021-03-15 22:22:24

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
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:31:6: ( jdSection | codeSection )* eof= EOF
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:31:6: ( jdSection | codeSection )*
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:32:7: jdSection
					{
					pushFollow(FOLLOW_jdSection_in_start64);
					jdSection();
					state._fsp--;

					 translation.append(jd.getTranslation()); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:34:7: codeSection
					{
					pushFollow(FOLLOW_codeSection_in_start97);
					codeSection();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			eof=(Token)match(input,EOF,FOLLOW_EOF_in_start116); 
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
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:42:3: (code= CODE )+
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:43:4: code= CODE
					{
					code=(Token)match(input,CODE,FOLLOW_CODE_in_codeSection185); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:48:1: jdSection : (code= JDS (description= TEXT | inline )* ( keyValue )* jde= JDE ) ;
	public final void jdSection() throws RecognitionException {
		Token code=null;
		Token description=null;
		Token jde=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:48:10: ( (code= JDS (description= TEXT | inline )* ( keyValue )* jde= JDE ) )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:49:3: (code= JDS (description= TEXT | inline )* ( keyValue )* jde= JDE )
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:49:3: (code= JDS (description= TEXT | inline )* ( keyValue )* jde= JDE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:49:12: code= JDS (description= TEXT | inline )* ( keyValue )* jde= JDE
			{
			 	jd = new Javadoc(debug); 
			code=(Token)match(input,JDS,FOLLOW_JDS_in_jdSection225); 
			 	if (code != null) c.addCode((code!=null?code.getText():null));
			    										translation.append(c.getTranslation()); 
			 jd.buffer.setLength(0);
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:53:3: (description= TEXT | inline )*
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==TEXT) ) {
					alt3=1;
				}
				else if ( (LA3_0==OPEN_BRACE) ) {
					alt3=2;
				}

				switch (alt3) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:54:4: description= TEXT
					{
					description=(Token)match(input,TEXT,FOLLOW_TEXT_in_jdSection263); 
					 jd.buffer.append((description!=null?description.getText():null) + " "); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:56:4: inline
					{
					pushFollow(FOLLOW_inline_in_jdSection277);
					inline();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			 jd.addDescription(jd.buffer.toString());
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:58:3: ( keyValue )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==KEY_AUTHOR||(LA4_0 >= KEY_EXCEPTION && LA4_0 <= KEY_PARAM)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:59:6: keyValue
					{
					pushFollow(FOLLOW_keyValue_in_jdSection302);
					keyValue();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			jde=(Token)match(input,JDE,FOLLOW_JDE_in_jdSection318); 
			 jd.addLastLine((jde!=null?jde.getText():null)); 
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
	// $ANTLR end "jdSection"



	// $ANTLR start "keyValue"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:66:1: keyValue : ( (key= KEY_PARAM ( inline |text= TEXT )* ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* ) | (key= KEY_AUTHOR ( inline |text= TEXT )* ) );
	public final void keyValue() throws RecognitionException {
		Token key=null;
		Token text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:66:9: ( (key= KEY_PARAM ( inline |text= TEXT )* ) | (key= KEY_EXCEPTION ( inline |text= TEXT )* ) | (key= KEY_AUTHOR ( inline |text= TEXT )* ) )
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:67:3: (key= KEY_PARAM ( inline |text= TEXT )* )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:67:3: (key= KEY_PARAM ( inline |text= TEXT )* )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:68:10: key= KEY_PARAM ( inline |text= TEXT )*
					{
					key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyValue356); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:69:10: ( inline |text= TEXT )*
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
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:70:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue388);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:72:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue420); 
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:76:5: (key= KEY_EXCEPTION ( inline |text= TEXT )* )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:76:5: (key= KEY_EXCEPTION ( inline |text= TEXT )* )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:77:10: key= KEY_EXCEPTION ( inline |text= TEXT )*
					{
					key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyValue483); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:78:10: ( inline |text= TEXT )*
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
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:79:14: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue514);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:81:14: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue546); 
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:85:6: (key= KEY_AUTHOR ( inline |text= TEXT )* )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:85:6: (key= KEY_AUTHOR ( inline |text= TEXT )* )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:86:4: key= KEY_AUTHOR ( inline |text= TEXT )*
					{
					key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyValue601); 
					 jd.buffer.setLength(0);
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:87:13: ( inline |text= TEXT )*
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
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:88:17: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue648);
							inline();
							state._fsp--;

							}
							break;
						case 2 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:90:17: text= TEXT
							{
							text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue686); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:97:1: inline : (before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE ) ;
	public final void inline() throws RecognitionException {
		Token before=null;
		Token key=null;
		Token inline_text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:97:7: ( (before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE ) )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:97:9: (before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE )
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:97:9: (before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\J2LParser.g:98:4: before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE
			{
			before=(Token)match(input,OPEN_BRACE,FOLLOW_OPEN_BRACE_in_inline766); 
			key=(Token)match(input,KEY_CODE,FOLLOW_KEY_CODE_in_inline770); 
			inline_text=(Token)match(input,CLOSED_BRACE,FOLLOW_CLOSED_BRACE_in_inline774); 
			}

			 jd.addInlineCode((before!=null?before.getText():null), key, (inline_text!=null?inline_text.getText():null)); 
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



	public static final BitSet FOLLOW_jdSection_in_start64 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_codeSection_in_start97 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_EOF_in_start116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CODE_in_codeSection185 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_JDS_in_jdSection225 = new BitSet(new long[]{0x0000000000003D40L});
	public static final BitSet FOLLOW_TEXT_in_jdSection263 = new BitSet(new long[]{0x0000000000003D40L});
	public static final BitSet FOLLOW_inline_in_jdSection277 = new BitSet(new long[]{0x0000000000003D40L});
	public static final BitSet FOLLOW_keyValue_in_jdSection302 = new BitSet(new long[]{0x0000000000000D40L});
	public static final BitSet FOLLOW_JDE_in_jdSection318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyValue356 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_inline_in_keyValue388 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue420 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyValue483 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_inline_in_keyValue514 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue546 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyValue601 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_inline_in_keyValue648 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_TEXT_in_keyValue686 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_OPEN_BRACE_in_inline766 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_KEY_CODE_in_inline770 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CLOSED_BRACE_in_inline774 = new BitSet(new long[]{0x0000000000000002L});
}
