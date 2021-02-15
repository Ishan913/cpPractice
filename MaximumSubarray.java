public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        return recurse(nums,nums.length-1)[0];

    }

    public static int[] recurse(int[] nums,int i){
        if (i==0)
            return new int[]{nums[0],1};
        int max = recurse(nums,i-1)[0];
        int cond=recurse(nums,i-1)[1];
        if (cond==1){
            int m =Math.max(Math.max(max,max+nums[i]),nums[i]);
            if (m==nums[i]|| m==max+nums[i]){
                return new int[]{m,1};
            }else
                return new int[]{m,0};
        }else {
            if (max<nums[i])
                return new int[]{nums[i],1};
            else
                return new int[]{max,0};
        }
//            return new int[]{Math.max(Math.max(max,max+nums[i]),nums[i])};

    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4}));
    }

}
