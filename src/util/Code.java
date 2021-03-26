package util;

import java.util.ArrayList;

/**
 * Classe di utility per la generazione della traduzione di una sezione di
 * codice.
 *
 * Essa viene istanziata nel momento in cui viene riconosciuto l'inizio di
 * una sezione di codice.
 *
 * @author Lorenzo Conti        ({@link https://www.lorenzoconti.dev sito web})
 * @author Fabio Sangregorio    ({@link https://fabio.sangregorio.dev sito web})
 *
 * @version 1.0.0
 */
public class Code {
    /** Indica se mostrare messaggi di debug su stdout. */
    public boolean debug;
    /** Buffer contenente la traduzione finale di output della sezione. */
    public StringBuffer output;

    /**
     * Costruttore della classe, il quale inizializza il buffer.
     *
     * @param debug Indica se mostrare messaggi di debug su stdout.
     */
    public Code(boolean debug) {
        this.debug = debug;
        this.output = new StringBuffer();
    }

    /**
     * Ritorna la traduzione di tutti gli elementi Code accumulati
     * fino ad ora, formattata in formato LaTeX.
     *
     * @return Stringa di testo contente la traduzione.
     */
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

    /**
     * Aggiunge del codice alla sezione di Code.
     * @param text Codice da aggiungere
     */
    public void addCode(String text) {
        if (text.trim().length() > 0) {
            output.append(text).append("\n");
        }
        if (debug) {
            System.out.println(text);
        }
    }
}
