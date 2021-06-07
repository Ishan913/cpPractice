import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ShortestRoute {

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

    public static int solve(int[] stations, int n, int destination){
        int time=0;

        if (destination==0)
            return time;
        if (stations[destination] !=0){
            return time;
        }

        while (true){
            time++;
            if (destination+time <n){
                if (stations[destination+time]==2)
                    return time;
            }else if (destination-time >=0){
                if (stations[destination-time]==1)
                    return time;
            }else
                return -1;
        }

    }


    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int z = 0; z < test; z++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int stations[] = new int[n];
            int passengers[] = new int[m];
            for (int i = 0; i < n; i++) {
                stations[i]= in.nextInt();
            }

//            HashMap< Integer,Integer> tt = new HashMap<Integer, Integer>();
//            for (int i = 0; i < n; i++) {
//                if (i==0)
//                    tt.put(i,0);
//                else if (stations[i]!=0)
//                    tt.put(i,0);
//                else
//                    tt.put(i,Integer.MAX_VALUE);
//            }
//            int check=-1;
//            for (int i = 0; i < n; i++) {
//                if (stations[i]==1)
//                    check=i;
//                if (check!=-1){
//                    if (stations[i]==0)
//                        tt.replace(i,Math.min(i-check,tt.get(i)));
//                }
//            }
//
//            check=-1;
//            for (int i = n-1; i >=0; i--) {
//                if (stations[i]==2)
//                    check=i;
//                if (check!=-1){
//                    if (stations[i]==0)
//                        tt.replace(i,Math.min(check-i,tt.get(i)));
//                }
//            }


//            using arrays
            int[] time = new int[n];
            for (int i = 0; i < n; i++) {
                if (i==0)
                    time[i]=0;
                else if (stations[i]!=0)
                    time[i]=0;
                else
                    time[i]=Integer.MAX_VALUE;
            }

            int check=-1;
            for (int i = 0; i < n; i++) {
                if (stations[i]==1)
                    check=i;
                if (check!=-1){
                    if (stations[i]==0)
                        time[i]=Math.min(i-check,time[i]);
                }
            }

            check=-1;
            for (int i = n-1; i >=0; i--) {
                if (stations[i]==2)
                    check=i;
                if (check!=-1){
                    if (stations[i]==0)
                        time[i]=Math.min(check-i,time[i]);
                }
            }
//


            for (int i = 0; i < m; i++) {
                int destination = in.nextInt()-1;
                if (time[destination]== Integer.MAX_VALUE)
                    writer.println(-1);
                else
                    writer.println(time[destination]);
//                System.out.println(solve(stations,n,in.nextInt()-1));
//                passengers[i]= in.nextInt();
            }

        }
        writer.flush();
        writer.close();
    }
}
