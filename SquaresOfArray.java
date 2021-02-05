import java.util.Arrays;

public class SquaresOfArray {

    public static int[] sortedSquares(int[] nums) {
        int i=0;
        int[] n = new int[nums.length];
        for (i = 0; i < nums.length; i++) {
            if (nums[i]>=0)
                break;
        }
        int u=i;
        i--;

        for (int j = 0; j < nums.length; j++) {
            if (i<0){
                n[j]= (int) Math.pow(nums[u],2);
                u++;
            }else if (u>=nums.length){
                n[j]= (int) Math.pow(nums[i],2);
                i--;
            }
            else if (Math.pow(nums[i],2)<=Math.pow(nums[u],2)){
                n[j]= (int) Math.pow(nums[i],2);
                i--;
            }else if (Math.pow(nums[i],2)>Math.pow(nums[u],2)){
                n[j]= (int) Math.pow(nums[u],2);
                u++;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        sortedSquares(new int[]{-4,-1,0,3,10});
    }
}
