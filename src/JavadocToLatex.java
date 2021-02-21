// $ANTLR 3.5.1 C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g 2021-02-21 18:01:49



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
	@Override public String getGrammarFileName() { return "C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g"; }



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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:43:1: start : ( jdSection |cs= codeSection )* eof= EOF ;
	public final void start() throws RecognitionException {
		Token eof=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:43:7: ( ( jdSection |cs= codeSection )* eof= EOF )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:43:9: ( jdSection |cs= codeSection )* eof= EOF
			{
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:43:9: ( jdSection |cs= codeSection )*
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
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:44:6: jdSection
					{
					pushFollow(FOLLOW_jdSection_in_start32);
					jdSection();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:46:6: cs= codeSection
					{
					pushFollow(FOLLOW_codeSection_in_start48);
					codeSection();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			eof=(Token)match(input,EOF,FOLLOW_EOF_in_start65); 
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:52:1: codeSection : (code= CODE )+ ;
	public final void codeSection() throws RecognitionException {
		Token code=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:53:2: ( (code= CODE )+ )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:54:6: (code= CODE )+
			{
			 writeLine("\\begin(code)\n"); 
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:56:6: (code= CODE )+
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
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:57:10: code= CODE
					{
					code=(Token)match(input,CODE,FOLLOW_CODE_in_codeSection112); 
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:61:1: jdSection : (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE ) ;
	public final void jdSection() throws RecognitionException {
		Token code=null;
		Token text=null;
		Token key=null;
		Token jde=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:62:2: ( (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE ) )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:63:2: (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE )
			{
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:63:2: (code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:64:2: code= JDS (text= TEXT | keyValue )* (key= KEY )? jde= JDE
			{
			code=(Token)match(input,JDS,FOLLOW_JDS_in_jdSection139); 

			                        endCode(code);
			                        System.out.println("\\begin(jd)\n");
					            
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:68:4: (text= TEXT | keyValue )*
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
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:69:5: text= TEXT
					{
					text=(Token)match(input,TEXT,FOLLOW_TEXT_in_jdSection161); 
					 System.out.println((text!=null?text.getText():null) + "\n"); 
					}
					break;
				case 2 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:71:5: keyValue
					{
					pushFollow(FOLLOW_keyValue_in_jdSection177);
					keyValue();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:73:4: (key= KEY )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==KEY) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:74:6: key= KEY
					{
					key=(Token)match(input,KEY,FOLLOW_KEY_in_jdSection197); 
					 System.out.println((key!=null?key.getText():null)); 
					}
					break;

			}

			jde=(Token)match(input,JDE,FOLLOW_JDE_in_jdSection215); 
			 System.out.println((jde!=null?jde.getText():null) + "\n"); 
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
	// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:81:1: keyValue : key= KEY text= TEXT ;
	public final void keyValue() throws RecognitionException {
		Token key=null;
		Token text=null;

		try {
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:82:2: (key= KEY text= TEXT )
			// C:\\projects\\unibg\\javadoc-to-latex\\src\\JavadocToLatex.g:82:4: key= KEY text= TEXT
			{
			key=(Token)match(input,KEY,FOLLOW_KEY_in_keyValue245); 
			text=(Token)match(input,TEXT,FOLLOW_TEXT_in_keyValue249); 
			 System.out.print((key!=null?key.getText():null) + " " + (text!=null?text.getText():null)); 
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

	// Delegated rules



	public static final BitSet FOLLOW_jdSection_in_start32 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_codeSection_in_start48 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_EOF_in_start65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CODE_in_codeSection112 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_JDS_in_jdSection139 = new BitSet(new long[]{0x00000000000001A0L});
	public static final BitSet FOLLOW_TEXT_in_jdSection161 = new BitSet(new long[]{0x00000000000001A0L});
	public static final BitSet FOLLOW_keyValue_in_jdSection177 = new BitSet(new long[]{0x00000000000001A0L});
	public static final BitSet FOLLOW_KEY_in_jdSection197 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_JDE_in_jdSection215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KEY_in_keyValue245 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_TEXT_in_keyValue249 = new BitSet(new long[]{0x0000000000000002L});
}
