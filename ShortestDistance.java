public class ShortestDistance {

    public static int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        int pos=Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c) {
                ans[i] = 0;
                pos=i;
            }
            else{
                if (pos == Integer.MAX_VALUE) {
                    ans[i]=Integer.MAX_VALUE;
                }else{
                    ans[i]=pos-i;
                }
            }
        }
        pos=Integer.MAX_VALUE;

        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)==c){
                pos=i;
                ans[i]=0;
            }else{
                if (pos!=Integer.MAX_VALUE){
                    ans[i]=Math.min(ans[i],pos-i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

//        shortestToChar("loveleetcode", 'e');
    }
}
