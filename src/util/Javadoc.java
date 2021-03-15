package util;

import java.util.ArrayList;
import java.util.Arrays;
import org.antlr.runtime.Token;

public class Javadoc {

    public ArrayList<String> params;
    public ArrayList<String> authors;
    public ArrayList<String> exceptions;

    public StringBuffer description;

    public ArrayList<String> listPointer = new ArrayList<String>();

    boolean lastDescription = true;
    boolean requiresSplit = true;

    // used in J2LParser.g
    public StringBuffer buffer = new StringBuffer();
    boolean debug;

    StringBuffer output = new StringBuffer();

    public Javadoc(boolean debug) {
        this.debug = debug;

        this.params = new ArrayList<String>();
        this.authors = new ArrayList<String>();
        this.exceptions = new ArrayList<String>();

        this.description = new StringBuffer();
    }

    public String getTranslation() {

        if(!this.authors.isEmpty()) {
            if(this.authors.size() == 1) _append("\\textbf{Author:} " + this.authors.get(0));
            else _append("\\textbf{Authors:} " + String.join(", ", this.authors));
            _append("");
        }

        if(this.description.length() > 0) {
            _append("\\textbf{Description:}");
            _append(this.description.toString());
            _append("");
        }

        if(!this.params.isEmpty()) {
            _append("\\textbf{Parameters:}");
            _append("\\begin{itemize}");
            for (String param : this.params) _append("  \\item" + param);
            _append("\\end{itemize}");
            _append("");
        }

        if(!this.exceptions.isEmpty()) {
            _append("\\textbf{Exceptions raised:}");
            _append("\\begin{itemize}");
            for (String exc : this.exceptions) _append("  \\item" + exc);
            _append("\\end{itemize}");
            _append("");
        }

        return this.output.toString();
    }

    public void addParam(String content) {

        lastDescription = false;
        listPointer = params;

        if (content.trim().length() > 0) {

            requiresSplit = false;

            String[] splitted = _split(content);
            String param = splitted[0];

            String output = "\\texttt{" + param + "}";

            if (splitted.length > 1) {
                String body = splitted[1];
                output = output.concat(" " + body);
            }

            this.params.add(output);
            _debug(output);
        }
        else {
            requiresSplit = true;
        }

    }

    public void addDescription(String text) {

        String output = text;

        this.description.append(output);

        _debug(output);
    }

    public void addException(String content) {

        lastDescription = false;
        listPointer = exceptions;

        String[] splitted = _split(content);
        String param = splitted[0];
        String body = splitted[1];

        String output = "\\texttt{" + param + "} " + body;

        this.exceptions.add(output);
       _debug(output);
    }

    public void addAuthor(String author){

        lastDescription = false;
        listPointer = authors;

        String[] output = author.trim().split(",");

        listPointer.addAll(Arrays.asList(output));

        _debug(author);
    }

    /* ------- PRIVATE METHODS ------- */

    private String[] _split(String content) {
        String[] splitted;

        // TODO if (content.length() > 0) splitted = content.split(" ", 2);
        // TODO: ELSE
        splitted = content.split(" ", 2);

        String param = splitted[0];
        String body = "" ;

        if (splitted.length > 1) body = splitted[1];

        return new String[] {param, body};
    }

    public void addLastLine(String text) {
        if (lastDescription) {
            this.description.append(text);
        }
        else {
            if (requiresSplit) {
                if (listPointer.equals(this.params))        { addParam(text); }
                if (listPointer.equals(this.exceptions))    { addException(text); }
                if (listPointer.equals(this.authors))       { addAuthor(text); }
            }
            else {
                listPointer.set(listPointer.size() - 1, listPointer.get(listPointer.size() - 1).concat(text));
            }
        }
    }

    public void addInlineCode(String before, Token key, String inline) {

        if (this.buffer.toString().isEmpty() && before.length() <= 1)  {
            System.err.println("Undeclared parameter or missing description at line " + key.getLine() + " before the inline code.");
        }
        else {
            this.buffer.append(before).append("\\texttt{").append(inline).append("}");
        }
    }

    private void _debug(String text) {
        if(this.debug) System.out.println("DEBUG: " + text);
    }

    private void _append(String text) {
        this.output.append(text + "\n");
    }
}
