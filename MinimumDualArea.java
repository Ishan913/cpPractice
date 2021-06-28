import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MinimumDualArea {

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

    public static int area(int a, int b, int c, int d){ //minx, max x min y max y
        return Math.abs((b-a)*(d-c));
    }


    public static void main(String[] args) {
        FastReader m = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        int test = m.nextInt();
        for (int z = 0; z < test; z++) {
            int n = m.nextInt();
            int points[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = m.nextInt();
                points[i][1] = m.nextInt();
            }
            if (n == 1 || n==2) {
                writer.println(0);
            }
            else {
                int[][] LeftMinMaxY = new int[n][2];
                int[][] RightMinMaxY = new int[n][2];
                sortbyColumn(points, 0);

                //debug after sort
//                for (int i = 0; i < n; i++) {
//                    System.out.println(points[i][0]+", "+points[i][1]);
//                }

                int max = points[0][1];
                int min = points[0][1];
                for (int i = 0; i < n; i++) {
                    if (points[i][1] < min)
                        min = points[i][1];
                    else if (points[i][1] > max)
                        max = points[i][1];
                    LeftMinMaxY[i][0] = min;
                    LeftMinMaxY[i][1] = max;
                }

                //debug after left to right traversal min and max Y
//                for (int i = 0; i < n; i++) {
//                    System.out.println(LeftMinMaxY[i][0]+", "+LeftMinMaxY[i][1]);
//                }

                max = points[n - 1][1];
                min = points[n - 1][1];
                for (int i = n -1; i >= 0; i--) {
                    if (points[i][1] < min)
                        min = points[i][1];
                    else if (points[i][1] > max)
                        max = points[i][1];
                    RightMinMaxY[i][0] = min;
                    RightMinMaxY[i][1] = max;
                }

                //debug after right to left traversal min and max Y
//                for (int i = 0; i < n; i++) {
//                    System.out.println(RightMinMaxY[i][0]+", "+RightMinMaxY[i][1]);
//                }

                int sum = Integer.MAX_VALUE;
//                int left = 1;
//                int right = n - 2;
//                while (left <= right) {
//                    int newsum = area(points[left - 1][0], points[left][0], LeftMinMaxY[left - 1][0], LeftMinMaxY[left - 1][1]) + area(points[right][0], points[right + 1][0], RightMinMaxY[right][0], RightMinMaxY[right][1]);
//                    if (newsum < sum)
//                        sum = newsum;
//                    left++;
//                    right--;
//                }

                //2nd approach
                for (int i = 0; i < n-1; i++) {
                    int areaSum = area(points[0][0],points[i][0],LeftMinMaxY[i][0],LeftMinMaxY[i][1])+ area(points[i+1][0],points[n-1][0],RightMinMaxY[i+1][0],RightMinMaxY[i+1][1]);
                    if (areaSum < sum)
                        sum = areaSum;
                }


                //UP DOWN
                int[][] DownMinMaxX = new int[n][2];
                int[][] UpMinMaxX = new int[n][2];
                sortbyColumn(points, 1);

                //debug after sort
//                for (int i = 0; i < n; i++) {
//                    System.out.println(points[i][0]+", "+points[i][1]);
//                }

                max = points[0][0];
                min = points[0][0];
                for (int i = 0; i < n; i++) {
                    if (points[i][0] < min)
                        min = points[i][0];
                    else if (points[i][0] > max)
                        max = points[i][0];
                    DownMinMaxX[i][0] = min;
                    DownMinMaxX[i][1] = max;
                }
                max = points[n - 1][0];
                min = points[n - 1][0];
                for (int i = n - 1; i >= 0; i--) {
                    if (points[i][0] < min)
                        min = points[i][0];
                    else if (points[i][0] > max)
                        max = points[i][0];
                    UpMinMaxX[i][0] = min;
                    UpMinMaxX[i][1] = max;
                }
                int sum2 = Integer.MAX_VALUE;
//                left = 1;
//                right = n - 2;
//                while (left <= right) {
//                    int newsum = area(points[left - 1][1], points[left][1], LeftMinMaxY[left - 1][0], LeftMinMaxY[left - 1][1]) + area(points[right][1], points[right + 1][1], RightMinMaxY[right][0], RightMinMaxY[right][1]);
//                    if (newsum < sum)
//                        sum2 = newsum;
//                    left++;
//                    right--;
//                }

                //2nd approach
                for (int i = 0; i < n-1; i++) {
                    int areaSum = area(points[0][1],points[i][1],DownMinMaxX[i][0],DownMinMaxX[i][1])+ area(points[i+1][1],points[n-1][1],UpMinMaxX[i+1][0],UpMinMaxX[i+1][1]);
                    if (areaSum < sum2)
                        sum2 = areaSum;
                }


                if (Math.min(sum, sum2)==Integer.MAX_VALUE)
                    writer.println(0);
                else
                    writer.println(Math.min(sum, sum2));
//                writer.println(sum+ " "+sum2);
            }
        }


        writer.flush();
        writer.close();
    }
}
