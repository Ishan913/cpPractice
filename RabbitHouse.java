import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RabbitHouse {

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        int t = m.nextInt();
        for (int j = 0; j < t; j++) {
            int r = m.nextInt();
            int c = m.nextInt();
            int[][] visited = new int[r][c];
            int[][] house = new int[r][c];
            ArrayList<int[]> orderedPair = new ArrayList<int[]>();
            for (int i = 0; i < r; i++) {
                for (int k = 0; k < c; k++) {
                    house[i][k] = m.nextInt();
                    orderedPair.add(new int[]{house[i][k],i,k});
                }
            }
            Collections.sort(orderedPair, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            for (int i = 0; i < orderedPair.size(); i++) {
                int row =orderedPair.get(i)[1];
                int col =orderedPair.get(i)[2];
                
            }

        }
    }
}
