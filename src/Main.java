import java.io.*;
import org.antlr.runtime.*;

public class Main {
    static public void main(String argv[]) {
        try {

            JDTLScanner lexer = new JDTLScanner(new FileReader("src/java_code.txt"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            JavadocToLatex parser = new JavadocToLatex(tokenStream);
            parser.start();

            try (PrintWriter out = new PrintWriter("output.tex")) {
                out.print(parser.getTranslation());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}