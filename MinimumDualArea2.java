import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class MinimumDualArea2 {

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

    public static void sortbyColumn(int arr[][], int col){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            // Compare values according to columns
            public int compare(final int[] entry1, final int[] entry2){
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void main(String[] args) {
        FastReader m = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        int test = m.nextInt();
        for (int z = 0; z < test; z++) {
            int n = m.nextInt();
            int[][] pointsX = new int[n][2];
            int[][] pointsY = new int[n][2];

            PriorityQueue<Integer> maximX = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1<o2)
                        return 1;
                    else if (o1>o2)
                        return -1;
                    else
                        return 0;
                }
            });
            PriorityQueue<Integer> maximY = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1<o2)
                        return 1;
                    else if (o1>o2)
                        return -1;
                    else
                        return 0;
                }
            });
            PriorityQueue<Integer> minimX = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1>o2)
                        return 1;
                    else if (o1<o2)
                        return -1;
                    else
                        return 0;
                }
            });
            PriorityQueue<Integer> minimY = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1>o2)
                        return 1;
                    else if (o1<o2)
                        return -1;
                    else
                        return 0;
                }
            });

            for (int i = 0; i < n; i++) {
                int x= m.nextInt();
                int y = m.nextInt();
                pointsX[i]=new int[]{x,y};
                pointsY[i]=new int[]{y,x};
                maximX.add(x);
                minimX.add(x);
                maximY.add(y);
                minimY.add(y);
            }

            sortbyColumn(pointsX,0);
            sortbyColumn(pointsY,0);

//            while (!minimY.isEmpty()) {
//                System.out.println(minimY.remove());
//            }

            int h1Max=0;
            int h1Min= Integer.MAX_VALUE;
            long area = Long.MAX_VALUE;
            for (int i = 0; i < n-1; i++) {
                h1Max = Math.max(h1Max,pointsX[i][1]);
                h1Min = Math.min(h1Min,pointsX[i][1]);
                int height1 = h1Max-h1Min;
                maximY.remove(pointsX[i][1]);
                minimY.remove(pointsX[i][1]);
                int height2 = maximY.peek()-minimY.peek();
                long newArea = (pointsX[i][0]-pointsX[0][0])*height1 + (pointsX[n-1][0]-pointsX[i+1][0])*height2;
                area=Math.min(area,newArea);
            }
//            System.out.println(area);
            
            int w1Max=0;
            int w1Min=Integer.MAX_VALUE;
            for (int i = 0; i < n-1; i++) {
                w1Max=Math.max(w1Max,pointsY[i][1]);
                w1Min=Math.min(w1Min,pointsY[i][1]);
                int width1 = w1Max-w1Min;
                maximX.remove(pointsY[i][1]);
                minimX.remove(pointsY[i][1]);
                int width2 = maximX.peek()-minimX.peek();
                long newArea = (pointsY[i][0]-pointsY[0][0])*width1 + (pointsY[n-1][0]-pointsY[i+1][0])*width2;
                area=Math.min(area,newArea);
            }
            if (area == Long.MAX_VALUE)
                area=0;
            writer.println(area);
        }
        writer.flush();
        writer.close();
    }
}
