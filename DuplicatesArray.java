public class DuplicatesArray {


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int ans=0;
        for (int j=1;j<nums.length;j++){
            if (nums[ans]!=nums[j]) {
                ans++;
                nums[ans]=nums[j];
            }
        }
        return ++ans;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

}
