# javadoc-to-latex
Easily compile and format Javadoc entities to LaTeX.

# Usage

## Compilation
1. Move to src 
    ```bash
    cd src
    ```
1. Compile the jflex lexer to Java:
    ```bash
    jflex cup_scanner.flex
    ```
1. Compile the cup parser to Java:
    ```bash
    java -jar ../lib/java-cup-11b.jar parser.cup
    ```
1. Compile the generated Java classes with javac:
    ```bash
    javac -cp ../lib/java-cup-11b-runtime.jar *.java
    ```
1. Run main

# To do
* (Fabio) Aggiungere funzionalità di caricamento preambolo nel file latex e generazione del file latex completo
* (Fabio) Gestire semantica del codice
* Spostare la semantica in metodi
* Gestire liste delle chiavi
* Gestione degli errori (tipo "/** EOF")