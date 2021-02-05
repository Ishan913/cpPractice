import java.util.Arrays;

public class LongestPrefix {

    public static String longestCommon(String[] strs){
        if (strs.length==0)
            return "";
        Arrays.sort(strs);
        String ans = strs[0];

        for (int i=1;i<strs.length;i++){
            int x=0;
            while(x<ans.length() && x<strs[i].length()){
                if (ans.charAt(x)!=strs[i].charAt(x)){
                    ans=ans.substring(0,x);
                    break;
                }
                x++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestCommon(new String[]{"aba","a"}));
    }
}
