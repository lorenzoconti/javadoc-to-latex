import java.io.*;

public class Main {
    static public void main(String argv[]) {
        try {
            Scanner l = new Scanner(new FileReader("src/java_code.txt"));
            parser p = new parser(l);
            Object result = p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}