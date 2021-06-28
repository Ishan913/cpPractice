import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FriendsAndCandies2 {

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
            int[] candies = new int[n];
            int sum=0;
            for (int i = 0; i < n; i++) {
                candies[i]=in.nextInt();
                sum=sum+candies[i];
            }
            if (sum%n!=0)
                System.out.println(-1);
            else{
                int indi = sum/n;
                int ans=0;
                for (int i = 0; i < n; i++) {
                    if (candies[i]>indi)
                        ans++;
                }
                System.out.println(ans);
            }
        }
    }
}
