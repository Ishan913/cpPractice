public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int isEmpty=0;
        int rep=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                if (isEmpty==0){
                    rep=i;
                    isEmpty=1;
                }
            }else {
                if (isEmpty==1){
                    nums[rep]=nums[i];
                    nums[i]=0;
                    rep++;
                }
            }
        }

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
