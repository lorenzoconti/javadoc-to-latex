import java.io.*;
import org.antlr.runtime.*;

public class Main {
    static public void main(String argv[]) {
        try {
            //Object lexer = new Object(new FileReader("src/java_code.txt"));

            //CommonTokenStream tokens = new CommonTokenStream(lexer);

            /*parser p = new parser(l);
            Object result = p.parse();
            System.out.println(result);*/


            JDTLScanner lexer = new JDTLScanner(new FileReader("src/java_code.txt"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            JavadocToLatex parser = new JavadocToLatex(tokenStream);
            parser.start();








        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}