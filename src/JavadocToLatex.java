// $ANTLR 3.5.1 D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g 2021-02-03 22:05:54

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JavadocToLatex extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CODE", "JDE", "JDS", "KEY", "TEXT"
	};
	public static final int EOF=-1;
	public static final int CODE=4;
	public static final int JDE=5;
	public static final int JDS=6;
	public static final int KEY=7;
	public static final int TEXT=8;

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



	// $ANTLR start "start"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:4:1: start : ( jdSection | codeSection )* eof= EOF ;
	public final void start() throws RecognitionException {
		Token eof=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:4:7: ( ( jdSection | codeSection )* eof= EOF )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:4:9: ( jdSection | codeSection )* eof= EOF
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:4:9: ( jdSection | codeSection )*
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:4:11: jdSection
					{
					pushFollow(FOLLOW_jdSection_in_start15);
					jdSection();
					state._fsp--;

					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:4:23: codeSection
					{
					pushFollow(FOLLOW_codeSection_in_start19);
					codeSection();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			eof=(Token)match(input,EOF,FOLLOW_EOF_in_start25); 
			 System.out.println(eof + "\n"); 
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
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:6:1: codeSection : (code= CODE )+ ;
	public final void codeSection() throws RecognitionException {
		Token code=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:7:2: ( (code= CODE )+ )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:7:4: (code= CODE )+
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:7:4: (code= CODE )+
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
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:7:5: code= CODE
					{
					code=(Token)match(input,CODE,FOLLOW_CODE_in_codeSection39); 
					 System.out.println(code + "\n"); 
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


	public static class jdSection_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "jdSection"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:10:1: jdSection : (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE ) ;
	public final JavadocToLatex.jdSection_return jdSection() throws RecognitionException {
		JavadocToLatex.jdSection_return retval = new JavadocToLatex.jdSection_return();
		retval.start = input.LT(1);

		Token code=null;
		Token text=null;
		Token key=null;
		Token jde=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:11:2: ( (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE ) )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:12:2: (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE )
			{
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:12:2: (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:13:2: code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE
			{
			code=(Token)match(input,JDS,FOLLOW_JDS_in_jdSection61); 
			 System.out.println(code + "\n"); 
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:14:4: (text= TEXT | keyValue )*
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==KEY) ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1==TEXT) ) {
						alt3=2;
					}

				}
				else if ( (LA3_0==TEXT) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:15:5: text= TEXT
					{
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_jdSection77); 
					 System.out.println(text + "\n"); 
					}
					break;
				case 2 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:17:5: keyValue
					{
					pushFollow(FOLLOW_keyValue_in_jdSection92);
					keyValue();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:19:7: (key= KEY )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==KEY) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:19:7: key= KEY
					{
					key=(Token)match(input,KEY,FOLLOW_KEY_in_jdSection107); 
					}
					break;

			}

			 System.out.println(key + "\n"); 
			jde=(Token)match(input,JDE,FOLLOW_JDE_in_jdSection119); 
			 System.out.println(jde + "\n"); 
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "jdSection"


	public static class keyValue_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "keyValue"
	// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:24:1: keyValue : key= KEY text= TEXT ;
	public final JavadocToLatex.keyValue_return keyValue() throws RecognitionException {
		JavadocToLatex.keyValue_return retval = new JavadocToLatex.keyValue_return();
		retval.start = input.LT(1);

		Token key=null;
		Token text=null;

		try {
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:25:2: (key= KEY text= TEXT )
			// D:\\develop\\lfc\\javadoc-to-latex\\src\\JavadocToLatex.g:25:4: key= KEY text= TEXT
			{
			key=(Token)match(input,KEY,FOLLOW_KEY_in_keyValue141); 
			text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue145); 
			 System.out.println(key + " " + text); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "keyValue"

	// Delegated rules



	public static final BitSet FOLLOW_jdSection_in_start15 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_codeSection_in_start19 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_EOF_in_start25 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CODE_in_codeSection39 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_JDS_in_jdSection61 = new BitSet(new long[]{0x00000000000001A0L});
	public static final BitSet FOLLOW_TEXT_in_jdSection77 = new BitSet(new long[]{0x00000000000001A0L});
	public static final BitSet FOLLOW_keyValue_in_jdSection92 = new BitSet(new long[]{0x00000000000001A0L});
	public static final BitSet FOLLOW_KEY_in_jdSection107 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_JDE_in_jdSection119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_in_keyValue141 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_TEXT_in_keyValue145 = new BitSet(new long[]{0x0000000000000002L});
}
