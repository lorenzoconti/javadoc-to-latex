package util;

import java.util.ArrayList;
import java.util.Arrays;
import org.antlr.runtime.Token;

public class Javadoc {

    public ArrayList<String> params;
    public ArrayList<String> authors;
    public ArrayList<String> exceptions;

    public StringBuffer description;
    public StringBuffer version;
    public StringBuffer deprecated;
    public StringBuffer returns;

    public ArrayList<String> listPointer = new ArrayList<>();
    public StringBuffer stringPointer = null;

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
        this.deprecated = new StringBuffer();
        this.returns = new StringBuffer();
        this.version = new StringBuffer();
    }

    public String getTranslation() {
        if(!this.authors.isEmpty()) {
            if(this.authors.size() == 1) _append("\\textbf{Author:} " + this.authors.get(0));
            else _append("\\textbf{Authors:} " + String.join(", ", this.authors));
            _append("");
        }

        if(this.version.length() > 0) {
            _append("\\textbf{Version:}: " + this.version.toString());
            _append("");
        }

        if(this.deprecated.length() > 0) {
            _append("Attention! This is deprecated: " + this.deprecated.toString());
            _append("");
        }

        if(this.description.toString().trim().replace(" ", "").length() > 0) {
            _append("\\textbf{Description:}");
            _append(this.description.toString());
            _append("");
        }
        else {
            System.out.println("Warning: you might put a description in your javadoc sections.");
        }

        if(!this.params.isEmpty()) {
            _append("\\textbf{Parameters:}");
            _append("\\begin{itemize}");
            for (String param : this.params) _append("  \\item" + param);
            _append("\\end{itemize}");
            _append("");
        }

        if(this.deprecated.length() > 0) {
            _append("\\textbf{Returns:}");
            _append(this.returns.toString());
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

        requiresSplit = true;

        if (!(listPointer.equals(params)) && params.size() > 0) {
            System.out.println("Warning: @param found among other Javadoc keywords. You should put all paramaters together.");
        }

        stringPointer = null;
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

        this.stringPointer = this.description;

        this.description.append(text);
        _debug(text);
    }

    public void addVersion(String text) {

        this.listPointer = new ArrayList<>();

        this.stringPointer = this.version;

        this.version.append(text);
        _debug(text);
    }

    public void addException(String content) {

        requiresSplit = true;

        if (!(listPointer.equals(exceptions))) {
            System.out.println("Warning: @exception found among other Javadoc keywords. You should put all exceptions together.");
        }

        stringPointer = null;
        listPointer = exceptions;

        if (content.trim().length() > 0) {
            String[] splitted = _split(content);
            String param = splitted[0];

            String output = "\\texttt{" + param + "}";

            if (splitted.length > 1) {
                String body = splitted[1];
                output = output.concat(" " + body);
            }

            this.exceptions.add(output);
            _debug(output);
        }
        else {
            requiresSplit = true;
        }
    }

    public void addAuthor(String author){

        if (!listPointer.equals(authors)) {
            System.out.println("Warning: @author found among other Javadoc keywords. You should put all authors together.");
        }

        stringPointer = null;
        listPointer = authors;

        String[] output = author.trim().split(",");
        listPointer.addAll(Arrays.asList(output));

        _debug(author);
    }

    public void addDeprecated(String text){
        stringPointer = this.deprecated;
        listPointer = new ArrayList<>();

        this.deprecated.append(text);
        _debug(text);
    }

    public void addReturn(String text){
        stringPointer = this.returns;
        listPointer = new ArrayList<>();

        this.returns.append(text);
        _debug(text);
    }

    /* ------- PRIVATE METHODS ------- */

    private String[] _split(String content) {
        String[] splitted;

        splitted = content.split(" ", 2);

        String param = splitted[0];
        String body = "" ;

        if (splitted.length > 1) body = splitted[1];

        return new String[] {param, body};
    }

    public void addLastLine(Token token) {

        String text = token.getText();

        if (stringPointer == this.description) { this.description.append(text); }
        else if (stringPointer == this.version) {
            if (version.length() > 0) { System.err.println("Version number must be specified on a single line at line " + token.getLine()); }
            else { this.version.append(text);}
        }
        else {
            if (requiresSplit) {
                if (listPointer.equals(this.params))        { addParam(text); }
                if (listPointer.equals(this.exceptions))    { addException(text); }
                if (listPointer.equals(this.authors))       { addAuthor(text); }
            }
            else {
                listPointer.set(listPointer.size() - 1, listPointer.get(listPointer.size() - 1).concat(" " + text));
            }
        }
    }

    public void addInlineCode(String before, Token key, String inline) {
        if (this.buffer.toString().isEmpty() && before.length() <= 1)  {
            System.err.println("Undeclared parameter or missing description at line " + key.getLine() + " before the inline code.");
        }
        else {
            if (inline.trim().replace(" ", "").length() > 0) {
                this.buffer.append(before).append("\\texttt{").append(inline).append("}");
            } else {
                this.buffer.append(before);
                System.err.println("Missing code block in @code at line " + key.getLine());
            }
        }
    }

    public void addInlineLink(String before, Token key, String inline) {
        if (this.buffer.toString().isEmpty() && before.length() <= 1)  {
            System.err.println("Undeclared parameter or missing description at line " + key.getLine() + " before the inline link.");
            return;
        }
        String[] splitted = _split(inline);
        String url = splitted[0];
        String label = splitted[1];

        if (label.length() == 0) label = url;

        String result = "\\href{" + url + "}{" + label + "}";

        this.buffer.append(before).append(result);

    }

    private void _debug(String text) {
        if(this.debug) System.out.println("DEBUG: " + text);
    }

    private void _append(String text) {
        this.output.append(text).append("\n");
    }
}
