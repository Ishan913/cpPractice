import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FriendsAndCandies {

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

    public static void recurse(int[] candies, int[] keepcheck){
        int max = Arrays.stream(candies).max().getAsInt();
        int min = Arrays.stream(candies).min().getAsInt();
        if (max ==min){
            return;
        }
        int maxIndex=0;
        int minIndex=0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i]==max)
                maxIndex=i;
            else if (candies[i]==min)
                minIndex=i;
        }
        keepcheck[maxIndex]=1;
        candies[maxIndex]=candies[maxIndex]- (max-min)/2;
        candies[minIndex]=candies[minIndex]+ (max-min)/2;
        recurse(candies,keepcheck);
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
                sum=sum%n+candies[i]%n;
            }
            if (sum%n!=0)
                System.out.println(-1);
            else{
                int[] keepCheck = new int[n];
                recurse(candies,keepCheck);
                int ans=0;
                for (int i = 0; i < n; i++) {
                    if (keepCheck[i]==1)
                        ans++;
                }
                System.out.println(ans);

            }
        }
    }
}
