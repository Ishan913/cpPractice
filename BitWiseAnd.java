import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BitWiseAnd {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    static int power(int A,
                           int B, int C)
    {

        // Base cases
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;

        // If B is even
        long y;
        if (B % 2 == 0)
        {
            y = power(A, B / 2, C);
            y = (y * y) % C;
        }

        // If B is odd
        else
        {
            y = A % C;
            y = (y * power(A, B - 1,
                    C) % C) % C;
        }

        return (int)((y + C) % C);
    }

    public static void main(String[] args) {
        FastReader m = new FastReader();
        int test = m.nextInt();
        for (int i = 0; i < test; i++) {


            int n = m.nextInt();
            int Mm = m.nextInt();

            int modulo = 1000000007;
            int x = power(2, n, modulo);
            x = (x - (1) % modulo) % modulo;
            x=power(x, Mm, modulo);
                System.out.println(x);
        }

    }
}
