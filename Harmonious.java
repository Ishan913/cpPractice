import java.util.Arrays;
import java.util.Scanner;

public class Harmonious {

        public static void merge(int arr[], int l, int m, int r)
        {
            int n1 = m - l + 1;
            int n2 = r - m;

            int L[] = new int[n1];
            int R[] = new int[n2];

            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];

            int i = 0, j = 0;

            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                }
                else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
        public static void sort(int arr[], int l, int r)
        {
            if (l < r) {
                int m =l+ (r-l)/2;

                sort(arr, l, m);
                sort(arr, m + 1, r);

                merge(arr, l, m, r);
            }
        }

    public static int findLHS(int[] nums) {
//        sort(nums,0,nums.length-1);
        Arrays.sort(nums);
        int ans=0;
        int short_ans=1;
        int included=0;

        for (int i=0;i<nums.length-1;i++){
            included=0;
            short_ans=1;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]-nums[i]==0)
                    short_ans++;
                else if (nums[j]-nums[i]==1){
                    short_ans++;
                    included=1;
                }
                else{
                    break;
                }
            }
//            System.out.println(i+" "+included+" "+ short_ans);
            if (included==1){
                if (ans<short_ans)
                    ans=short_ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        int[] nums = new int[]{1,1,2,2};
        System.out.println(findLHS(nums));
    }
}
