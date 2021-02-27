package util;

import java.util.ArrayList;

public class Javadoc {

    public ArrayList<String> params;
    public ArrayList<String> authors;
    public ArrayList<String> exceptions;

    public StringBuffer description;

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

    public void addParam(String inline, String text) {
        String[] splitted = _split(inline, text);
        String param = splitted[0];
        String body = splitted[1];

        String output = "\\texttt{" + param + "} " + body;

        this.params.add(output);
        _debug(output);
    }

    public void addDescription(String text) {
        String output = text;

        this.description.append(output);
        _debug(output);
    }

    public void addException(String inline, String text) {
        String[] splitted = _split(inline, text);
        String param = splitted[0];
        String body = splitted[1];

        String output = "\\texttt{" + param + "} " + body;

        this.exceptions.add(output);
       _debug(output);
    }

    public void addAuthor(String author){
        // TODO: controllare se è un autore o una lista di autori

        this.authors.add(author);
        _debug(author);
    }

    /* ------- PRIVATE METHODS ------- */

    private String[] _split(String inline, String text) {
        String[] splitted;

        if (inline.length() > 0) splitted = inline.split(" ", 2);
        else splitted = text.split(" ", 2);

        String param = splitted[0];
        String body = splitted[1] + " " + text;

        return new String[] {param, body};
    }

    private void _debug(String text) {
        if(this.debug) System.out.println("DEBUG: " + text);
    }

    private void _append(String text) {
        this.output.append(text + "\n");
    }
}
