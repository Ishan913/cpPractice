public class RepeatedString {
    public static boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i=l/2;i>0;i--){
            if (l%i==0){
                String pattern = s.substring(0,i);
                String st2 = pattern.repeat(l/i);
                if (st2.equals(s))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abaabaaba"));
        System.out.println(repeatedSubstringPattern("a"));
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }
}
