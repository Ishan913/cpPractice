import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumXOR {

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

    public static int solve(int n, int k){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i+1;
        }
        int maxXor = Integer.MIN_VALUE;
        int[] solutionArray = new int[k];

        for (int i = 0; i < (1 << n); i++){
            if (Integer.bitCount(i) == k){
                int[] array=new int[k];
                int ind=0;
                int newXOR = 0;
                for (int j = 0; j < n; j++){
                    if ((i & (1 << j)) == 0) {
                        newXOR = newXOR ^ arr[j];
//                        System.out.println(ind+" "+j);
//                        array[ind]=arr[j];
                        ind++;
                    }
                }

                if (maxXor<newXOR){
                    maxXor=newXOR;
//                    solutionArray=array;
                }
            }
        }
//        return solutionArray;
        return maxXor;
    }

    public static int solve2(int[]arr,int n,int k){
        int current_xor = 0 ;
        for (int i = 0 ; i < k ; i++)
            current_xor = current_xor ^ arr[i];


        int max_xor = current_xor;

        for (int i = k ; i < n; i++)
        {

            // First remove previous subarray's first
            // element
            current_xor = current_xor ^ arr[i-k];

            // add new element
            current_xor = current_xor ^ arr[i];

            // Update maximum xor value
            max_xor = Math.max(max_xor, current_xor);
        }

        return max_xor;
    }


    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int z = 0; z < test; z++) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (k==1){
                writer.println(n);
            }else{
//                int[] ans = solve(n,k-1);
//                for (int i = 0; i < ans.length; i++) {
//                    writer.println(ans[i]);
//                }
//                writer.println(solve(n,k));

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i]=i+1;
                }
                writer.println(solve2(arr,n,k));
            }

        }
        writer.flush();
        writer.close();
    }
}
