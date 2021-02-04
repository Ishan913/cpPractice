public class ReverseInteger {

    public static int reverse(int x){
        int ans=0;

        while (x!=0){
            int temp = x%10;
            x/=10;
            if ((temp>7 && ans==Integer.MAX_VALUE/10) || ans>Integer.MAX_VALUE/10){
                return 0;
            }
            if ((temp<-8 && ans==Integer.MIN_VALUE/10) || ans<Integer.MIN_VALUE/10){
                return 0;
            }
            ans=ans*10+temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        int x=321;
//        reverse(x);
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
