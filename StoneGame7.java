import java.util.Scanner;

public class StoneGame7 {

    public static int[][] sumBetweenIndeices;
    public static int[][][] dpArray;

    public static int stoneGameVII(int[] stones) {
        int n=stones.length;

        sumBetweenIndeices = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j==i)
                    sumBetweenIndeices[i][j]=stones[i];
                else
                    sumBetweenIndeices[i][j]= sumBetweenIndeices[i][j-1]+stones[j];
            }
        }

        dpArray= new int[n][n][2];//turn==0 => Alice, turn==1 => Bob
        return dpBuild(0,n-1,0);

    }

    public static int dpBuild(int left, int right, int turn){
        if (dpArray[left][right][turn]!=0)
            return dpArray[left][right][turn];

        if (turn==0){//Alice
            //right picked
            int scoreDiffRigth = sumBetweenIndeices[left][right-1] + dpBuild(left,right-1,1);
            int scoreDiffLeft = sumBetweenIndeices[left+1][right] + dpBuild(left+1,right,1);
            dpArray[left][right][0]=Math.max(scoreDiffLeft,scoreDiffRigth);
            return dpArray[left][right][turn];
        }
        else {//Bob
            int scoreDiffRight = dpBuild(left,right-1,0) - sumBetweenIndeices[left][right-1];
            int scoreDiffLeft = dpBuild(left+1,right,0) - sumBetweenIndeices[left+1][right];
            dpArray[left][right][1]=Math.min(scoreDiffLeft,scoreDiffRight);
            return dpArray[left][right][turn];
        }
    }

    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));

    }
}
