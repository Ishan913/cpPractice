public class PalindromeNumber {

    public static boolean isPalindrome(int x){
        if (x<0)
            return false;
        if (x<10)
            return true;
        int upper = (int) Math.pow(10,Integer.toString(x).length()-1);
        int lower=1;

        while (upper>lower){
            int a=(x/upper)%10;
            int b=(x/lower)%10;
            if (a!=b){
                return false;
            }
            upper/=10;
            lower*=10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
    }

}
