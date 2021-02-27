// $ANTLR 3.5.1 C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g 2021-02-27 21:03:13

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
	@Override public String getGrammarFileName() { return "C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g"; }


	    boolean debug = true;

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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:37:1: start : ( jdSection | codeSection )* eof= EOF ;
	public final void start() throws RecognitionException {
		Token eof=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:38:5: ( ( jdSection | codeSection )* eof= EOF )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:38:7: ( jdSection | codeSection )* eof= EOF
			{
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:38:7: ( jdSection | codeSection )*
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
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:38:33: jdSection
					{
					 jd = new Javadoc(debug); 
					pushFollow(FOLLOW_jdSection_in_start61);
					jdSection();
					state._fsp--;

					 translation.append(jd.getTranslation()); 
					}
					break;
				case 2 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:41:6: codeSection
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:47:1: codeSection : (code= CODE )+ ;
	public final void codeSection() throws RecognitionException {
		Token code=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:48:5: ( (code= CODE )+ )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:48:33: (code= CODE )+
			{
			writeLine("\\begin{lstlisting}[language=Java]");
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:49:2: (code= CODE )+
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
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:50:3: code= CODE
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:55:1: jdSection : (code= JDS (text= TEXT | keyValue )* keyJDE ) ;
	public final void jdSection() throws RecognitionException {
		Token code=null;
		Token text=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:56:2: ( (code= JDS (text= TEXT | keyValue )* keyJDE ) )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:56:4: (code= JDS (text= TEXT | keyValue )* keyJDE )
			{
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:56:4: (code= JDS (text= TEXT | keyValue )* keyJDE )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:57:3: code= JDS (text= TEXT | keyValue )* keyJDE
			{
			code=(Token)match(input,JDS,FOLLOW_JDS_in_jdSection208); 
			 endCode(code); System.out.println("\\begin(jd)\n"); 
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:58:3: (text= TEXT | keyValue )*
			loop3:
			while (true) {
				int alt3=3;
				alt3 = dfa3.predict(input);
				switch (alt3) {
				case 1 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:60:6: text= TEXT
					{
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_jdSection239); 
					 jd.addDescription((text!=null?text.getText():null)); 
					}
					break;
				case 2 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:62:6: keyValue
					{
					pushFollow(FOLLOW_keyValue_in_jdSection262);
					keyValue();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			pushFollow(FOLLOW_keyJDE_in_jdSection271);
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:69:1: keyValue : ( (key= KEY_PARAM ( inline )* text= TEXT ) | (key= KEY_EXCEPTION ( inline )* text= TEXT ) |key= KEY_AUTHOR text= TEXT );
	public final void keyValue() throws RecognitionException {
		Token key=null;
		Token text=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:70:2: ( (key= KEY_PARAM ( inline )* text= TEXT ) | (key= KEY_EXCEPTION ( inline )* text= TEXT ) |key= KEY_AUTHOR text= TEXT )
			int alt6=3;
			switch ( input.LA(1) ) {
			case KEY_PARAM:
				{
				alt6=1;
				}
				break;
			case KEY_EXCEPTION:
				{
				alt6=2;
				}
				break;
			case KEY_AUTHOR:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:70:4: (key= KEY_PARAM ( inline )* text= TEXT )
					{
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:70:4: (key= KEY_PARAM ( inline )* text= TEXT )
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:71:9: key= KEY_PARAM ( inline )* text= TEXT
					{
					key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyValue325); 
					 jd.buffer.setLength(0);
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:72:9: ( inline )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==OPEN_BRACE) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:72:9: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue340);
							inline();
							state._fsp--;

							}
							break;

						default :
							break loop4;
						}
					}

					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue353); 
					}

					 jd.addParam(jd.buffer.toString(), (text!=null?text.getText():null)); 
					}
					break;
				case 2 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:75:4: (key= KEY_EXCEPTION ( inline )* text= TEXT )
					{
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:75:4: (key= KEY_EXCEPTION ( inline )* text= TEXT )
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:76:9: key= KEY_EXCEPTION ( inline )* text= TEXT
					{
					key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyValue389); 
					 jd.buffer.setLength(0);
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:77:9: ( inline )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==OPEN_BRACE) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:77:9: inline
							{
							pushFollow(FOLLOW_inline_in_keyValue403);
							inline();
							state._fsp--;

							}
							break;

						default :
							break loop5;
						}
					}

					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue416); 
					}

					 jd.addException(jd.buffer.toString(), (text!=null?text.getText():null)); 
					}
					break;
				case 3 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:81:5: key= KEY_AUTHOR text= TEXT
					{
					key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyValue451); 
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue455); 
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:85:1: inline : before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE ;
	public final void inline() throws RecognitionException {
		Token before=null;
		Token key=null;
		Token inline_text=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:86:2: (before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:86:4: before= OPEN_BRACE key= KEY_CODE inline_text= CLOSED_BRACE
			{
			before=(Token)match(input,OPEN_BRACE,FOLLOW_OPEN_BRACE_in_inline472); 
			key=(Token)match(input,KEY_CODE,FOLLOW_KEY_CODE_in_inline476); 
			inline_text=(Token)match(input,CLOSED_BRACE,FOLLOW_CLOSED_BRACE_in_inline480); 
			 jd.buffer.append((before!=null?before.getText():null) + " \\texttt{" + (inline_text!=null?inline_text.getText():null) + "}");  
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:91:1: keyJDE : ( (key= KEY_PARAM ( inline )* jde= JDE ) | (key= KEY_EXCEPTION jde= JDE ) | (key= KEY_AUTHOR jde= JDE ) | (key= KEY_CODE jde= JDE ) |text= JDE );
	public final void keyJDE() throws RecognitionException {
		Token key=null;
		Token jde=null;
		Token text=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:92:2: ( (key= KEY_PARAM ( inline )* jde= JDE ) | (key= KEY_EXCEPTION jde= JDE ) | (key= KEY_AUTHOR jde= JDE ) | (key= KEY_CODE jde= JDE ) |text= JDE )
			int alt8=5;
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
			case KEY_CODE:
				{
				alt8=4;
				}
				break;
			case JDE:
				{
				alt8=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:92:4: (key= KEY_PARAM ( inline )* jde= JDE )
					{
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:92:4: (key= KEY_PARAM ( inline )* jde= JDE )
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:93:3: key= KEY_PARAM ( inline )* jde= JDE
					{
					key=(Token)match(input,KEY_PARAM,FOLLOW_KEY_PARAM_in_keyJDE529); 
					 System.out.print("PARAM " + (key!=null?key.getText():null)); 
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:94:3: ( inline )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==OPEN_BRACE) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:94:3: inline
							{
							pushFollow(FOLLOW_inline_in_keyJDE541);
							inline();
							state._fsp--;

							}
							break;

						default :
							break loop7;
						}
					}

					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE551); 
					 System.out.print((jde!=null?jde.getText():null) + "\n"); 
					}

					}
					break;
				case 2 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:98:2: (key= KEY_EXCEPTION jde= JDE )
					{
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:98:2: (key= KEY_EXCEPTION jde= JDE )
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:99:3: key= KEY_EXCEPTION jde= JDE
					{
					key=(Token)match(input,KEY_EXCEPTION,FOLLOW_KEY_EXCEPTION_in_keyJDE578); 
					 System.out.println("EXCEPTION " + (key!=null?key.getText():null)); 
					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE591); 
					 System.out.println((jde!=null?jde.getText():null) + "\n"); 
					}

					}
					break;
				case 3 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:103:2: (key= KEY_AUTHOR jde= JDE )
					{
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:103:2: (key= KEY_AUTHOR jde= JDE )
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:104:3: key= KEY_AUTHOR jde= JDE
					{
					key=(Token)match(input,KEY_AUTHOR,FOLLOW_KEY_AUTHOR_in_keyJDE618); 
					 System.out.println("AUTHOR " + (key!=null?key.getText():null)); 
					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE632); 
					 System.out.println((jde!=null?jde.getText():null) + "\n"); 
					}

					}
					break;
				case 4 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:108:2: (key= KEY_CODE jde= JDE )
					{
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:108:2: (key= KEY_CODE jde= JDE )
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:109:3: key= KEY_CODE jde= JDE
					{
					key=(Token)match(input,KEY_CODE,FOLLOW_KEY_CODE_in_keyJDE659); 
					 System.out.println("CODE " + (key!=null?key.getText():null)); 
					jde=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE673); 
					 System.out.println((jde!=null?jde.getText():null) + "\n"); 
					}

					}
					break;
				case 5 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\J2LParser.g:113:2: text= JDE
					{
					text=(Token)match(input,JDE,FOLLOW_JDE_in_keyJDE697); 
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


	protected DFA3 dfa3 = new DFA3(this);
	static final String DFA3_eotS =
		"\12\uffff";
	static final String DFA3_eofS =
		"\12\uffff";
	static final String DFA3_minS =
		"\4\6\2\uffff\1\11\1\uffff\1\4\1\6";
	static final String DFA3_maxS =
		"\4\15\2\uffff\1\11\1\uffff\1\4\1\15";
	static final String DFA3_acceptS =
		"\4\uffff\1\3\1\1\1\uffff\1\2\2\uffff";
	static final String DFA3_specialS =
		"\12\uffff}>";
	static final String[] DFA3_transitionS = {
			"\1\4\1\uffff\1\3\1\4\1\2\1\1\1\uffff\1\5",
			"\1\4\5\uffff\1\6\1\7",
			"\1\4\5\uffff\2\7",
			"\1\4\6\uffff\1\7",
			"",
			"",
			"\1\10",
			"",
			"\1\11",
			"\1\4\5\uffff\1\6\1\7"
	};

	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
	static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
	static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
	static final short[][] DFA3_transition;

	static {
		int numStates = DFA3_transitionS.length;
		DFA3_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
		}
	}

	protected class DFA3 extends DFA {

		public DFA3(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 3;
			this.eot = DFA3_eot;
			this.eof = DFA3_eof;
			this.min = DFA3_min;
			this.max = DFA3_max;
			this.accept = DFA3_accept;
			this.special = DFA3_special;
			this.transition = DFA3_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 58:3: (text= TEXT | keyValue )*";
		}
	}

	public static final BitSet FOLLOW_jdSection_in_start61 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_codeSection_in_start91 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_EOF_in_start103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CODE_in_codeSection174 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_JDS_in_jdSection208 = new BitSet(new long[]{0x0000000000002F40L});
	public static final BitSet FOLLOW_TEXT_in_jdSection239 = new BitSet(new long[]{0x0000000000002F40L});
	public static final BitSet FOLLOW_keyValue_in_jdSection262 = new BitSet(new long[]{0x0000000000002F40L});
	public static final BitSet FOLLOW_keyJDE_in_jdSection271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyValue325 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_inline_in_keyValue340 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_TEXT_in_keyValue353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyValue389 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_inline_in_keyValue403 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_TEXT_in_keyValue416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyValue451 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_TEXT_in_keyValue455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_BRACE_in_inline472 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_KEY_CODE_in_inline476 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_CLOSED_BRACE_in_inline480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_PARAM_in_keyJDE529 = new BitSet(new long[]{0x0000000000001040L});
	public static final BitSet FOLLOW_inline_in_keyJDE541 = new BitSet(new long[]{0x0000000000001040L});
	public static final BitSet FOLLOW_JDE_in_keyJDE551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_EXCEPTION_in_keyJDE578 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_JDE_in_keyJDE591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_AUTHOR_in_keyJDE618 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_JDE_in_keyJDE632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_CODE_in_keyJDE659 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_JDE_in_keyJDE673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_JDE_in_keyJDE697 = new BitSet(new long[]{0x0000000000000002L});
}
