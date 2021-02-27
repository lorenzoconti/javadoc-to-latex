import java.util.ArrayList;

public class Javadoc {

    public ArrayList<String> params;
    public ArrayList<String> authors;
    public ArrayList<String> exceptions;

    public StringBuffer description;

    public Javadoc() {

        this.params = new ArrayList<String>();
        this.authors = new ArrayList<String>();
        this.exceptions = new ArrayList<String>();

        this.description = new StringBuffer();
    }

    public String getTranslation() {
        return this.description.toString() + " " + this.params.toString() + " " + this.authors.toString() + " " + this.exceptions.toString();
    }

    public void addParam(String inline, String text, boolean verbose) {

        String[] splitted;

        if (inline.length() > 0){
            splitted = inline.split(" ", 2);
        }
        else {
           splitted = text.split(" ", 2);
        }

        String param = splitted[0];
        String body = splitted[1] + " " + text;

        this.params.add("\\texttt{" + param + "} " + body);

        if (verbose) {
            System.out.println("\\texttt{" + param + "} " + body);
        }
    }

    public void addDescription(String text, boolean verbose) {

        this.description.append(text);

        if (verbose) {
            System.out.println(text);
        }
    }

    public void addException(String inline, String text, boolean verbose) {

        String[] splitted;

        if (inline.length() > 0){
            splitted = inline.split(" ", 2);
        }
        else {
            splitted = text.split(" ", 2);
        }

        String param = splitted[0];
        String body = splitted[1] + " " + text;

        this.exceptions.add("\\texttt{" + param + "} " + body);

        if (verbose) {
            System.out.println("\\texttt{" + param + "} " + body);
        }
    }

    public void addAuthor(String author, boolean verbose){

        // TODO: controllare se è un autore o una lista di autori

        this.authors.add(author);

        if (verbose) {
            System.out.println("Autore: " + author);
        }

    }

}
