// $ANTLR 3.5.1 D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g 2021-02-21 18:18:02



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JavadocToLatex extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CODE", "JDE", "JDS", "KEY_AUTHOR", 
		"KEY_CODE", "KEY_EXCEPTION", "KEY_PARAM", "TEXT"
	};
	public static final int EOF=-1;
	public static final int CODE=4;
	public static final int JDE=5;
	public static final int JDS=6;
	public static final int KEY_AUTHOR=7;
	public static final int KEY_CODE=8;
	public static final int KEY_EXCEPTION=9;
	public static final int KEY_PARAM=10;
	public static final int TEXT=11;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public JavadocToLatex(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public JavadocToLatex(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return JavadocToLatex.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g"; }



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




	// $ANTLR start "start"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:43:1: start : ( jdSection |cs= codeSection )* eof= EOF ;
	public final void start() throws RecognitionException {
		Token eof=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:43:7: ( ( jdSection |cs= codeSection )* eof= EOF )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:43:9: ( jdSection |cs= codeSection )* eof= EOF
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:43:9: ( jdSection |cs= codeSection )*
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:43:11: jdSection
					{
					pushFollow(FOLLOW_jdSection_in_start26);
					jdSection();
					state._fsp--;

					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:43:23: cs= codeSection
					{
					pushFollow(FOLLOW_codeSection_in_start32);
					codeSection();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			eof=(Token)match(input,EOF,FOLLOW_EOF_in_start39); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:46:1: codeSection : (code= CODE )+ ;
	public final void codeSection() throws RecognitionException {
		Token code=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:47:2: ( (code= CODE )+ )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:49:2: (code= CODE )+
			{
			writeLine("\\begin(code)\n");
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:51:2: (code= CODE )+
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:52:3: code= CODE
					{
					code=(Token)match(input,CODE,FOLLOW_CODE_in_codeSection68); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:57:1: jdSection : (code= JDS (text= TEXT | keyValue )* keyJDE ) ;
	public final void jdSection() throws RecognitionException {
		Token code=null;
		Token text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:58:2: ( (code= JDS (text= TEXT | keyValue )* keyJDE ) )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:60:2: (code= JDS (text= TEXT | keyValue )* keyJDE )
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:60:2: (code= JDS (text= TEXT | keyValue )* keyJDE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:61:3: code= JDS (text= TEXT | keyValue )* keyJDE
			{
			code=(Token)match(input,JDS,FOLLOW_JDS_in_jdSection102); 
			 endCode(code);
							  	  System.out.println("\\begin(jd)\n");
					            		
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:64:3: (text= TEXT | keyValue )*
			loop3:
			while (true) {
				int alt3=3;
				switch ( input.LA(1) ) {
				case KEY_PARAM:
					{
					int LA3_1 = input.LA(2);
					if ( (LA3_1==TEXT) ) {
						alt3=2;
					}

					}
					break;
				case KEY_EXCEPTION:
					{
					int LA3_3 = input.LA(2);
					if ( (LA3_3==TEXT) ) {
						alt3=2;
					}

					}
					break;
				case KEY_AUTHOR:
					{
					int LA3_4 = input.LA(2);
					if ( (LA3_4==TEXT) ) {
						alt3=2;
					}

					}
					break;
				case KEY_CODE:
					{
					int LA3_5 = input.LA(2);
					if ( (LA3_5==TEXT) ) {
						alt3=2;
					}

					}
					break;
				case TEXT:
					{
					alt3=1;
					}
					break;
				}
				switch (alt3) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:65:6: text= TEXT
					{
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_jdSection125); 
					 System.out.println((text!=null?text.getText():null) + "\n"); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:67:6: keyValue
					{
					pushFollow(FOLLOW_keyValue_in_jdSection144);
					keyValue();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			pushFollow(FOLLOW_keyJDE_in_jdSection156);
			keyJDE();
			state._fsp--;

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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:78:1: keyValue : (key= KEY_PARAM text= TEXT |key= KEY_EXCEPTION text= TEXT |key= KEY_AUTHOR text= TEXT |key= KEY_CODE text= TEXT );
	public final void keyValue() throws RecognitionException {
		Token key=null;
		Token text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:79:2: (key= KEY_PARAM text= TEXT |key= KEY_EXCEPTION text= TEXT |key= KEY_AUTHOR text= TEXT |key= KEY_CODE text= TEXT )
			int alt4=4;
			switch ( input.LA(1) ) {
			case KEY_PARAM:
				{
				alt4=1;
				}
				break;
			case KEY_EXCEPTION:
				{
				alt4=2;
				}
				break;
			case KEY_AUTHOR:
				{
				alt4=3;
				}
				break;
			case KEY_CODE:
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:80:3: key= KEY_PARAM text= TEXT
					{
					key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyValue186); 
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue191); 
					 System.out.print("PARAM " + (key!=null?key.getText():null) + " " + (text!=null?text.getText():null)); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:82:3: key= KEY_EXCEPTION text= TEXT
					{
					key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyValue204); 
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue208); 
					 System.out.print("EXCEPTION " + (key!=null?key.getText():null) + " " + (text!=null?text.getText():null)); 
					}
					break;
				case 3 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:84:3: key= KEY_AUTHOR text= TEXT
					{
					key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyValue221); 
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue226); 
					 System.out.print("AUTHOR " + (key!=null?key.getText():null) + " " + (text!=null?text.getText():null)); 
					}
					break;
				case 4 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:86:3: key= KEY_CODE text= TEXT
					{
					key=(Token)match(input,KEY_CODE,FOLLOW_KEY_CODE_in_keyValue239); 
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue243); 
					 System.out.print("CODE " + (key!=null?key.getText():null) + " " + (text!=null?text.getText():null)); 
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



	// $ANTLR start "keyJDE"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:89:1: keyJDE : ( ( (key= KEY_PARAM )? jde= JDE ) | ( (key= KEY_EXCEPTION )? jde= JDE ) | ( (key= KEY_AUTHOR )? jde= JDE ) | ( (key= KEY_CODE )? jde= JDE ) );
	public final void keyJDE() throws RecognitionException {
		Token key=null;
		Token jde=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:90:2: ( ( (key= KEY_PARAM )? jde= JDE ) | ( (key= KEY_EXCEPTION )? jde= JDE ) | ( (key= KEY_AUTHOR )? jde= JDE ) | ( (key= KEY_CODE )? jde= JDE ) )
			int alt9=4;
			switch ( input.LA(1) ) {
			case KEY_PARAM:
				{
				alt9=1;
				}
				break;
			case JDE:
				{
				alt9=1;
				}
				break;
			case KEY_EXCEPTION:
				{
				alt9=2;
				}
				break;
			case KEY_AUTHOR:
				{
				alt9=3;
				}
				break;
			case KEY_CODE:
				{
				alt9=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:91:2: ( (key= KEY_PARAM )? jde= JDE )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:91:2: ( (key= KEY_PARAM )? jde= JDE )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:92:3: (key= KEY_PARAM )? jde= JDE
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:92:3: (key= KEY_PARAM )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==KEY_PARAM) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:92:4: key= KEY_PARAM
							{
							key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyJDE267); 
							 System.out.println("PARAM " + (key!=null?key.getText():null)); 
							}
							break;

					}

					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE280); 
					 System.out.println((jde!=null?jde.getText():null) + "\n"); 
					}

					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:96:2: ( (key= KEY_EXCEPTION )? jde= JDE )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:96:2: ( (key= KEY_EXCEPTION )? jde= JDE )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:97:3: (key= KEY_EXCEPTION )? jde= JDE
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:97:3: (key= KEY_EXCEPTION )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==KEY_EXCEPTION) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:97:4: key= KEY_EXCEPTION
							{
							key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyJDE305); 
							 System.out.println("EXCEPTION " + (key!=null?key.getText():null)); 
							}
							break;

					}

					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE317); 
					 System.out.println((jde!=null?jde.getText():null) + "\n"); 
					}

					}
					break;
				case 3 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:101:2: ( (key= KEY_AUTHOR )? jde= JDE )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:101:2: ( (key= KEY_AUTHOR )? jde= JDE )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:102:3: (key= KEY_AUTHOR )? jde= JDE
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:102:3: (key= KEY_AUTHOR )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==KEY_AUTHOR) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:102:4: key= KEY_AUTHOR
							{
							key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyJDE341); 
							 System.out.println("AUTHOR " + (key!=null?key.getText():null)); 
							}
							break;

					}

					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE353); 
					 System.out.println((jde!=null?jde.getText():null) + "\n"); 
					}

					}
					break;
				case 4 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:106:2: ( (key= KEY_CODE )? jde= JDE )
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:106:2: ( (key= KEY_CODE )? jde= JDE )
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:107:3: (key= KEY_CODE )? jde= JDE
					{
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:107:3: (key= KEY_CODE )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==KEY_CODE) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:107:4: key= KEY_CODE
							{
							key=(Token)match(input,KEY_CODE,FOLLOW_KEY_CODE_in_keyJDE377); 
							 System.out.println("CODE " + (key!=null?key.getText():null)); 
							}
							break;

					}

					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE390); 
					 System.out.println((jde!=null?jde.getText():null) + "\n"); 
					}

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



	public static final BitSet FOLLOW_jdSection_in_start26 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_codeSection_in_start32 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_EOF_in_start39 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CODE_in_codeSection68 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_JDS_in_jdSection102 = new BitSet(new long[]{0x0000000000000FA0L});
	public static final BitSet FOLLOW_TEXT_in_jdSection125 = new BitSet(new long[]{0x0000000000000FA0L});
	public static final BitSet FOLLOW_keyValue_in_jdSection144 = new BitSet(new long[]{0x0000000000000FA0L});
	public static final BitSet FOLLOW_keyJDE_in_jdSection156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyValue186 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_TEXT_in_keyValue191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyValue204 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_TEXT_in_keyValue208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyValue221 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_TEXT_in_keyValue226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_CODE_in_keyValue239 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_TEXT_in_keyValue243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyJDE267 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_JDE_in_keyJDE280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyJDE305 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_JDE_in_keyJDE317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyJDE341 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_JDE_in_keyJDE353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_CODE_in_keyJDE377 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_JDE_in_keyJDE390 = new BitSet(new long[]{0x0000000000000002L});
}
