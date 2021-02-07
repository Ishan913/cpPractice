public class NeedleInHaystack {
    public static int strStr(String haystack, String needle) {
        int ans=-1;
        if (needle=="")
            return 0;

        for (int i=0;i<=haystack.length()-needle.length();i++){
            if (haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
    }
}
