import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberOfPairs {

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

    public static int solve(int[] nums, int z, int u) {
        int left = 0, right = nums.length - 1, count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum >= z ) {
                int x=left;
                int y=right;
                while (x<y){
                    int mid = x+ (y-x)/2;
                    if (nums[mid]+nums[right]<=u)
                        x=mid+1;
                    else
                        y=mid;
                }
                count+=x-left;
                right--;
            }
            else
                left++;
        }

        return count;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int test=in.nextInt();
        for (int i = 0; i < test; i++) {
            int n=in.nextInt();
            int l=in.nextInt();
            int u=in.nextInt();
            int[] arr =new int[n];
            for (int j = 0; j < n; j++) {
                arr[j]=in.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(solve(arr,l,u));
        }
    }
}
