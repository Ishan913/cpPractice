public class RobotMovement {

    public static boolean judgeCircle(String moves) {
        int l=0,r=0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i)=='L')
                l++;
            else if (moves.charAt(i)=='R')
                l--;
            else if (moves.charAt(i)=='U')
                r++;
            else
                r--;
        }

        if (l==0 && r==0)
            return true;
        return false;

    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("RLUURDDDLU"));
    }
}
