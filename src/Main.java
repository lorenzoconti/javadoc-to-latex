import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.runtime.*;

public class Main {
    static public void main(String argv[]) {
        try {
            J2LScanner scanner = new J2LScanner(new FileReader("src/util/Javadoc.java"));
            CommonTokenStream tokenStream = new CommonTokenStream(scanner);
            J2LParser parser = new J2LParser(tokenStream);
            try {
                parser.start();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            try (PrintWriter out = new PrintWriter("src/output/output.tex")) {
                Boolean withPreamble = argv.length > 0 && argv[0].equals("--with-preamble");
                if (withPreamble) {
                    String preamble = new String(Files.readAllBytes(Paths.get("src/util/preamble.tex")));
                    out.print(preamble + "\n");
                }
                out.print(parser.getTranslation());
                if (withPreamble) {
                    out.print("\n\\end{document}");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

