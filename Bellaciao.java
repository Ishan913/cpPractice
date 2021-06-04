import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bellaciao {

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
        FastReader m = new FastReader();
        int test = m.nextInt();

        for (int z = 0; z < test; z++){
            int totalDays = m.nextInt();
            int interval = m.nextInt();
            int rate = m.nextInt();
            int increment = m.nextInt();
            long amount =0;
            int i=0;
            while (i<totalDays-interval){
                amount+=rate*interval;
                rate+=increment;
                i+=interval;
            }
            amount+= (totalDays-i)*rate;

            System.out.println(amount);
        }



        for (int z = 0; z < test; z++) {
            long totalDays = m.nextLong();
            long interval = m.nextLong();
            long rate = m.nextLong();
            long increment = m.nextLong();
            long amount = rate*totalDays;
            long noOfINtervals = totalDays/interval -1;
            long leftOverDays = totalDays%interval;

            if (noOfINtervals%2==0){
                amount += increment*interval*((noOfINtervals/2*(noOfINtervals+1))) + leftOverDays*((noOfINtervals+1)*increment);

            }else{
                amount += increment*interval*((noOfINtervals*(noOfINtervals+1))/2) + leftOverDays*((noOfINtervals+1)*increment);

            }

//            amount += (double) ( (noOfINtervals+1)*increment*  (interval*noOfINtervals/2.0 + leftOverDays));

            System.out.println(amount);
        }
    }
}
