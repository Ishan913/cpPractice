import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> table = new HashMap<>();
        int[] ans = new int[2];
        for (int i=0;i<nums.length;i++){
            int compliment = target-nums[i];
            if (table.containsKey(compliment)){
                ans[0]=i+1;
                ans[1]=table.get(compliment)+1;
            }
            table.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums  = new int[]{2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums,target);
    }
}
