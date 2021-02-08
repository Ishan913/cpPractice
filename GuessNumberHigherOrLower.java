public class GuessNumberHigherOrLower {

    public static int guess(int num){
        return -1;
    }

    public static int guessNumber(int n) {
        int first=1;
        int last=n;
        while (first<=last){
            int mid=first + (last-first)/2;
            if (guess(mid)==0){
                return mid;
            }
            else if (guess(mid)<0){
                last=mid-1;
            }else {
                first=mid+1;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(15));
    }
}
