package util;

import java.util.ArrayList;
import java.util.Arrays;
import org.antlr.runtime.Token;

/**
 * Classe di utility per la generazione della traduzione di una sezione di
 * Javadoc.
 *
 * Essa viene istanziata nel momento in cui viene riconosciuto un token JDS.
 * Tutte le parole chiave di Javadoc supportate trovano una corrispondenza in
 * un attributo della classe, il quale contiene il loro valore. Si hanno due
 * tipi di attributi: sottoforma di {@code ArrayList} nel caso in cui Javadoc
 * preveda la possibile presenza di più istanze del suddetto tag, oppure
 * sottoforma di {@code StringBuffer} nel caso contrario.
 *
 * @uses org.antlr.runtime Per la gestione degli oggetti Token
 *
 * @author Lorenzo Conti        ({@link https://www.lorenzoconti.dev sito web})
 * @author Fabio Sangregorio    ({@link https://fabio.sangregorio.dev sito web})
 *
 * @version 1.0.0
 */
public class Javadoc {
    /**
     * Di seguito sono presenti gli attributi corrispondenti a tag multipli,
     * quindi sottoforma di {@code ArrayList}.
     */
    public ArrayList<String> params;
    public ArrayList<String> authors;
    public ArrayList<String> exceptions;
    public ArrayList<String> provides;
    public ArrayList<String> uses;
    public ArrayList<String> see;

    /**
     * Di seguito sono presenti gli attributi corrispondenti a tag singoli,
     * quindi sottoforma di {@code ArrayList}.
     */
    public StringBuffer description;
    public StringBuffer version;
    public StringBuffer deprecated;
    public StringBuffer returns;

    /**
     * {@code listPointer} tiene traccia dell'ultima lista utilizzata, in
     * modo da riconoscere eventuali tag di un tipo mischiati a tag di
     * altri tipi.
     * {@code stringPointer} fa la stessa cosa per i tag che possono
     * apparire solo una volta nella sezione di Javadoc.
     */
    public ArrayList<String> listPointer = new ArrayList<>();
    public StringBuffer stringPointer = null;

    /** Indica che il tag richiede uno split tra chiave e valore. */
    boolean requiresSplit = true;

    /** Buffer interno usato nella specifica ANTLR per la gestione
     * dei tag inline. */
    public StringBuffer buffer = new StringBuffer();
    /** Indica se mostrare messaggi di debug su stdout. */
    boolean debug;

    /** Buffer contenente la traduzione finale di outpu della sezione. */
    StringBuffer output = new StringBuffer();

    /**
     * Costruttore della classe, il quale inizializza le liste e i
     * buffer.
     *
     * @param debug Indica se mostrare messaggi di debug su stdout.
     */
    public Javadoc(boolean debug) {
        this.debug = debug;

        this.params = new ArrayList<String>();
        this.authors = new ArrayList<String>();
        this.exceptions = new ArrayList<String>();
        this.provides = new ArrayList<String>();
        this.uses = new ArrayList<String>();
        this.see = new ArrayList<String>();

        this.description = new StringBuffer();
        this.deprecated = new StringBuffer();
        this.returns = new StringBuffer();
        this.version = new StringBuffer();
    }

    /**
     * Ritorna la traduzione di tutti gli elementi Javadoc accumulati
     * fino ad ora, formattata in formato LaTeX.
     *
     * @return Stringa di testo contente la traduzione.
     *
     * @throws Warning Se la sezione di Javadoc non contiene una
     *  descrizione
     */
    public String getTranslation() {
        _append("\\vspace{0.5cm}");
        if(this.description.toString().trim().replace(" ", "").length() > 0) {
            _append("\\textbf{Description:} " + this.description.toString());
            _append("");
        }
        else {
            System.out.println("Warning: you might put a description in your javadoc sections.");
        }

        if(!this.authors.isEmpty()) {
            if(this.authors.size() == 1) _append("\\textbf{Author:} " + this.authors.get(0));
            else _append("\\textbf{Authors:} " + String.join(", ", this.authors));
            _append("");
        }

        if(this.version.length() > 0) {
            _append("\\textbf{Version:} " + this.version.toString());
            _append("");
        }

        if(this.deprecated.length() > 0) {
            _append("\\importantbox{\\textbf{Deprecated:} " + this.deprecated.toString() + "}");
            _append("");
        }

        if(!this.params.isEmpty()) {
            _append("\\textbf{Parameters:}");
            _append("\\begin{itemize}");
            for (String param : this.params) _append("  \\item" + param);
            _append("\\end{itemize}");
            _append("");
        }

        if(this.returns.length() > 0) {
            _append("\\textbf{Returns:}");
            _append(this.returns.toString());
            _append("");
        }

        if(!this.exceptions.isEmpty()) {
            _append("\\mybox{Raises}{orange!30}{orange!5}{");
            _append("\\begin{itemize}");
            for (String exc : this.exceptions) _append("  \\item" + exc);
            _append("\\end{itemize}");
            _append("}");
        }

        if(!this.provides.isEmpty() || !this.uses.isEmpty()) {
            _append("\\begin{table}[!h]\\centering");
            _append("\\begin{tabular}{|l|p{0.25\\textwidth}|p{0.5\\textwidth}|}");
            _append("\\hline & \\textbf{Service} & \\textbf{Description} \\\\ \\hline");
            if(!this.provides.isEmpty()) {
                _append("\\multirow{" + provides.size() + "}{*}{\\textbf{Provides}}");
                for (String p : this.provides) _append("& " + p + " \\\\");
                _append("\\hline");
            }
            if(!this.uses.isEmpty()) {
                _append("\\multirow{" + uses.size() + "}{*}{\\textbf{Uses}}");
                for (String u : this.uses) _append("& " + u + " \\\\");
                _append("\\hline");
            }
            _append("\\end{tabular}\\end{table}");
        }

        if(!this.see.isEmpty()) {
            _append("\\textbf{See also:}");
            _append("\\begin{itemize}");
            for (String exc : this.see) _append("  \\item" + exc);
            _append("\\end{itemize}");
            _append("");
        }

        return this.output.toString().replace("_", "\\_").replace("@", "\\atsign ");
    }

    /**
     * Aggiunge la descrizione della sezione Javadoc alla classe.
     * @param text Testo della descrizione
     */
    public void addDescription(String text) {
        this.listPointer = new ArrayList<>();
        this.stringPointer = this.description;
        this.stringPointer.append(text);
        _debug(text);
    }

    /**
     * Aggiunge la versione della sezione Javadoc alla classe.
     * @param text Numero di versione
     */
    public void addVersion(String text) {
        this.listPointer = new ArrayList<>();
        this.stringPointer = this.version;
        this.stringPointer.append(text);
        _debug(text);
    }

    /**
     * Aggiunge la descrizione della deprecazione alla classe.
     * @param text motivo della deprecazione
     */
    public void addDeprecated(String text){
        this.listPointer = new ArrayList<>();
        this.stringPointer = this.deprecated;
        this.stringPointer.append(text);
        _debug(text);
    }

    /**
     * Aggiunge la descrizione dell'oggetto di ritorno alla classe.
     * @param text Descrizione dell'oggetto ritornato
     */
    public void addReturn(String text){
        this.listPointer = new ArrayList<>();
        this.stringPointer = this.returns;
        this.stringPointer.append(text);
        _debug(text);
    }

    /**
     * Aggiunge un parametro alla lista dei parametri della classe.
     * @param content Testo contenente il nome e la descrizione del
     *                parametro
     *
     * @throws Warning Se la lista di @param è interrotta da altri
     * tag
     */
    public void addParam(String content) {
        requiresSplit = true;
        if (!listPointer.equals(params) && params.size() > 0) {
            System.out.println("Warning: @param found among other Javadoc keywords. You should put all paramaters together.");
        }
        stringPointer = null;
        listPointer = this.params;
        if (content.trim().length() == 0)  return;
        requiresSplit = false;

        String[] splitted = _split(content);
        String param = splitted[0];
        String body = splitted[1];

        String output = "\\texttt{" + param + "}";
        if (body.length() > 0) output = output.concat(" " + body);

        this.params.add(output);
        _debug(output);
    }

    /**
     * Aggiunge un'eccezione alla lista delle eccezioni della classe.
     * @param content Testo contenente il nome e la descrizione dell'
     *                eccezione
     *
     * @throws Warning Se la lista di @exception è interrotta da altri
     * tag
     */
    public void addException(String content) {
        requiresSplit = true;
        if (!listPointer.equals(exceptions) && exceptions.size() > 0) {
            System.out.println("Warning: @exception found among other Javadoc keywords. You should put all exceptions together.");
        }
        stringPointer = null;
        listPointer = this.exceptions;
        if (content.trim().length() == 0) return;
        requiresSplit = false;

        String[] splitted = _split(content);
        String param = splitted[0];
        String body = splitted[1];

        String output = "\\texttt{" + param + "}";
        if (body.length() > 0) output = output.concat(" " + body);

        this.exceptions.add(output);
        _debug(output);
    }

    /**
     * Aggiunge un provides alla lista dei provides della classe.
     * @param content Testo contenente il nome e la descrizione del
     *                provides
     *
     * @throws Warning Se la lista di @provides è interrotta da altri
     * tag
     */
    public void addProvides(String content) {
        requiresSplit = true;
        if (!listPointer.equals(provides) && provides.size() > 0) {
            System.out.println("Warning: @provides found among other Javadoc keywords. You should put all @provides together.");
        }
        stringPointer = null;
        listPointer = this.provides;
        if (content.trim().length() == 0) return;
        requiresSplit = false;

        String[] splitted = _split(content);
        String param = splitted[0];
        String body = splitted[1];

        String output = "\\texttt{" + param + "} &";
        if (body.length() > 0) output = output.concat(" " + body);

        listPointer.add(output);
        _debug(output);
    }

    /**
     * Aggiunge uno uses alla lista degli uses della classe.
     * @param content Testo contenente il nome e la descrizione dello
     *                uses
     *
     * @throws Warning Se la lista di @uses è interrotta da altri
     * tag
     */
    public void addUses(String content) {
        requiresSplit = true;
        if (!listPointer.equals(uses)  && uses.size() > 0) {
            System.out.println("Warning: @uses found among other Javadoc keywords. You should put all @uses together.");
        }
        stringPointer = null;
        listPointer = this.uses;
        if (content.trim().length() == 0) return;
        requiresSplit = false;

        String[] splitted = _split(content);
        String param = splitted[0];
        String body = splitted[1];

        String output = "\\texttt{" + param + "} &";
        if (body.length() > 0) output = output.concat(" " + body);

        listPointer.add(output);
        _debug(output);
    }

    /**
     * Aggiunge un see alla lista dei see della classe.
     * @param content Testo contenente la descrizione del see
     *
     * @throws Warning Se la lista di @see è interrotta da altri
     * tag
     */
    public void addSee(String content){
        requiresSplit = true;
        if (!listPointer.equals(see)  && see.size() > 0) {
            System.out.println("Warning: @see found among other Javadoc keywords. You should put all @see together.");
        }
        stringPointer = null;
        listPointer = this.see;
        if (content.trim().length() == 0) return;
        requiresSplit = false;

        String[] splitted = _split(content);
        String param = splitted[0];
        String body = splitted[1];

        if (body.length() == 0) body = param;
        String output = "\\href{" + param + "}{" + body + "}";

        listPointer.add(output);
        _debug(output);
    }

    /**
     * Aggiunge un autore alla lista degli autori della classe.
     * @param content Testo contenente uno o più autori, separati
     *                da virgola
     *
     * @throws Warning Se la lista di @author è interrotta da altri
     * tag
     */
    public void addAuthor(String content){
        requiresSplit = true;
        if (!listPointer.equals(authors)  && authors.size() > 0) {
            System.out.println("Warning: @author found among other Javadoc keywords. You should put all authors together.");
        }
        stringPointer = null;
        listPointer = this.authors;
        if (content.trim().length() == 0) return;

        String[] output = content.trim().split(",");

        listPointer.addAll(Arrays.asList(output));
        _debug(content);
    }

    /**
     * Aggiunge l'ultima linea di testo (portata dal token JDE) al
     * buffer o lista a cui appartiene.
     * @param token Token di ANTLR
     *
     * @throws Error Se @version è specificato su più righe
     */
    public void addLastLine(Token token) {
        String text = token.getText();

        if (stringPointer == this.description) { this.description.append(text); }
        else if (stringPointer == this.version) {
            if (version.length() > 0) { System.err.println("Version number must be specified on a single line at line " + token.getLine()); }
            else { this.version.append(text);}
        }
        else if (stringPointer == this.returns) { this.returns.append(text); }
        else if (stringPointer == this.deprecated) { this.deprecated.append(text); }
        else {
            if (requiresSplit) {
                if (listPointer.equals(this.params))        { addParam(text); }
                if (listPointer.equals(this.exceptions))    { addException(text); }
                if (listPointer.equals(this.authors))       { addAuthor(text); }
                if (listPointer.equals(this.provides))      { addProvides(text); }
                if (listPointer.equals(this.uses))          { addUses(text); }
                if (listPointer.equals(this.see))           { addSee(text); }
            }
            else {
                listPointer.set(listPointer.size() - 1, listPointer.get(listPointer.size() - 1).concat(" " + text));
            }
        }
    }

    /**
     * Gestisce il tag inline @code, aggiungendo il testo prima della parentesi
     * al buffer interno di accumulo, e formattando il contenuto di
     * @code, prima di appenderlo al buffer.
     *
     * @param before    Testo prima della parentesi
     * @param key       Token contenente la chiave
     * @param inline    Testo prima della parentesi
     *
     * @exception Error Se manca la descizione di @code
     */
    public void addInlineCode(String before, Token key, String inline) {
        if (this.buffer.toString().isEmpty() && before.length() <= 1)  {
            System.err.println("Undeclared parameter or missing description at line " + key.getLine() + " before the inline code.");
            return;
        }

        if (inline.trim().replace(" ", "").length() > 0) {
            this.buffer.append(before).append("\\texttt{").append(inline).append("}");
        } else {
            this.buffer.append(before);
            System.err.println("Missing code block in @code at line " + key.getLine());
        }
    }

    /**
     * Gestisce il tag inline @link, aggiungendo il testo prima della parentesi
     * al buffer interno di accumulo, e formattando il contenuto di
     * @link, prima di appenderlo al buffer.
     *
     * @param before    Testo prima della parentesi
     * @param key       Token contenente la chiave
     * @param inline    Testo prima della parentesi
     *
     * @exception Error Se manca la descizione di @code
     */
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

    /* ------- PRIVATE METHODS ------- */

    /**
     * Esegue lo split della string in input (tipicamente il testo di un
     * tag Javadoc) nelle due componenti di nome e descrizione del tag.
     *
     * @param content Stringa contenente il testo del tag
     * @return Un array di lunghezza pari 2, in cui il primo elemento
     * corrisponde al nome del parametro e il secondo alla descrizione.
     */
    private String[] _split(String content) {
        String[] splitted;
        splitted = content.split("\\s+", 2);

        String param = splitted[0];
        String body = "" ;

        if (splitted.length > 1) body = splitted[1];

        return new String[] {param, body};
    }

    /**
     * Esegue il print del testo in input se debug è true
     * @param text Testo da mandare in output
     */
    private void _debug(String text) {
        if(this.debug) System.out.println("DEBUG: " + text);
    }

    /**
     * Aggiunge il testo in input al buffer di output della sezione
     * di Javadoc, corredato di un fine linea.
     * @param text Testo da aggiungere
     */
    private void _append(String text) {
        this.output.append(text).append("\n");
    }
}
