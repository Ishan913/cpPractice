import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StoneGame {

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

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int test = in.nextInt();
        for (int z = 0; z < test; z++) {
            int n= in.nextInt();
            int[] power = new int[n];
            for (int i = 0; i < n; i++) {
                power[i]=in.nextInt();
            }
            int l1=0;
            int l2=0;
            int r1=0;
            int r2=0;
            for (int i = 0; i < n; i++) {
                if (power[i]==1){
                    l1= i+1;
                    r1=n-i;
                }
                else if (power[i]==n){
                    l2= i+1;
                    r2=n-i;
                }
            }
//            int ans1=Math.min(Math.max(l1,l2),Math.max(r1,r2));

            System.out.println(Math.min(Math.min(Math.max(l1,l2),Math.max(r1,r2)),Math.min(l1+r2,l2+r1)));
        }
    }
}
