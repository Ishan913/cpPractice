import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Readerb {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static Long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
public class SummerHeat {

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        int test = m.nextInt();

        for (int i = 0; i < test; i++) {
            int x = m.nextInt();
            int y = m.nextInt();
            int xx = m.nextInt();
            int yy = m.nextInt();
            System.out.println(xx/x + yy/y);
        }


    }
}
