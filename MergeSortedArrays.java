public class MergeSortedArrays {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int tots = m+n+1;
        for (int i =tots;i>=0;i--){
            if (m<0){
                nums1[i]=nums2[n];
                n--;
            }else if (n<0){
                nums1[i]=nums1[m];
                m--;
            }
            else if (nums1[m]>nums2[n]){
                nums1[i]=nums1[m];
                m--;
            }else{
                nums1[i]=nums2[n];
                n--;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] num=merge(new int[]{1,2,3,0,0,0}, 3,new int[]{2,5,6},3);
        for (int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }
//        System.out.println();
    }
}
