import java.util.Scanner;

public class Goodness {

    public static void main(String[] args) {
        Scanner m = new Scanner(System.in);
        int t = m.nextInt();
        for (int j = 0; j < t; j++) {
            int n = m.nextInt();
            int goodness = m.nextInt();
            String s  =m.next();
            int k =0;
            for (int i = 0; i <n/2 ; i++) {
                if (s.charAt(i) != s.charAt(n-i-1))
                    k++;
            }
            System.out.println("Case #"+(j+1)+": "+(Math.abs(goodness-k)));
        }
    }
}
