# javadoc-to-latex
Easily compile and format Javadoc entities to LaTeX.

# Usage

## Lexer

1. Compile the jflex lexer to Java:
    ```bash
    jflex .\lexer.flex
    ```
2. Compile the generated Java lexer with javac:
    ```bash
    javac .\Lexer.java
    ```
3. Use the lexer against an input file:
    ```bash
    java Lexer test.txt
    ```
