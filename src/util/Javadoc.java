package util;

import java.util.ArrayList;

public class Javadoc {

    public ArrayList<String> params;
    public ArrayList<String> authors;
    public ArrayList<String> exceptions;

    public StringBuffer description;

    public ArrayList<String> listPointer = new ArrayList<String>();
    public StringBuffer descriptionPointer = new StringBuffer();

    boolean lastDescription = true;


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

        String[] splitted = _split(content);
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

        // TODO: controllare se è un autore o una lista di autori
        this.authors.add(author);
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
            descriptionPointer.append(text);
        }
        else {
            listPointer.add(text);
        }
    }

    private void _debug(String text) {
        if(this.debug) System.out.println("DEBUG: " + text);
    }

    private void _append(String text) {
        this.output.append(text + "\n");
    }
}
