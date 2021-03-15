package util;

import java.util.ArrayList;

public class Code {

    public boolean debug;
    public StringBuffer output;

    public Code(boolean debug) {
        this.debug = debug;

        this.output = new StringBuffer();

    }

    public String getTranslation() {
        StringBuilder result = new StringBuilder();

        if (this.output.toString().replace("\n", "").trim().length() > 0) {
            result.append("\\begin{lstlisting}[language=Java]\n");
            result.append(output.toString());
            result.append("\\end{lstlisting}\n");
            this.output.setLength(0);
        }

        return result.toString();
    }

    public void addCode(String text) {

        // if(text.replace("\n", "").trim().length() > 0) {
        if (text.trim().length() > 0) {
            output.append(text).append("\n");
        }
        if (debug) {
            System.out.println(text);
        }
    }
}
