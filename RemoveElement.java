public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length==0)
            return 0;

        int isEmpty=0;
        int ind=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==val){
                if (isEmpty==0) {
                    isEmpty = 1;
                    ind = i;
                }
            }else if (isEmpty!=0){
                nums[ind]=nums[i];
                ind++;
            }
        }
        return ++ind;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}
