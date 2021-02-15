public class CountAndSay {

    public static String countAndSayMeth1(int n) {
        if (n==1){
            return "1";
        }
        StringBuilder ret = new StringBuilder();
        String ret2 = countAndSay(n-1);
        int x=0;
        char num=ret2.charAt(0);
        for (int i = 0; i < ret2.length(); i++) {
            if (num==ret2.charAt(i))
                x++;
            else {
                ret.append(x).append(num);
                x=1;
                num=ret2.charAt(i);
            }
        }
        ret.append(x).append(num);
        return ret.toString();
    }

    public static String countAndSay(int n) {
        if (n==1){
            return "1";
        }
        String ret = "1";
        for (int i = 1; i <n ; i++) {
            ret=f(ret);
        }
        return ret;
    }

    public static String f(String ret2){
        StringBuilder ret = new StringBuilder();
        int x=0;
        char num=ret2.charAt(0);
        for (int i = 0; i < ret2.length(); i++) {
            if (num==ret2.charAt(i))
                x++;
            else {
                ret.append(x).append(num);
                x=1;
                num=ret2.charAt(i);
            }
        }
        ret.append(x).append(num);
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
