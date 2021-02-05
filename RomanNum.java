public class RomanNum {

    public static int toRoman(String s){
        int ans=0;
        int i=0;
        while (i<s.length()){
//            System.out.println(ans);
            if (s.charAt(i)=='I'){
                if (i+1<s.length()){
                if (s.charAt(i+1)=='V'){
                    ans+=4;
                    i+=2;
                }
                else if (s.charAt(i+1)=='X'){
                    ans+=9;
                    i+=2;
                }else{
                    ans+=1;
                    i++;
                }
                }else{
                    ans+=1;
                    i++;
                }
            }else if (s.charAt(i)=='X') {
                if (i+1<s.length()){
                if (s.charAt(i + 1) == 'L') {
                    ans += 40;
                    i += 2;
                } else if (s.charAt(i + 1) == 'C') {
                    ans += 90;
                    i += 2;
                }else {
                    ans += 10;
                    i++;
                }
                }else {
                    ans += 10;
                    i++;
                }
            }else if (s.charAt(i)=='C') {
                if (i+1<s.length()){
                if (s.charAt(i + 1) == 'D') {
                    ans += 400;
                    i += 2;
                } else if (s.charAt(i + 1) == 'M') {
                    ans += 900;
                    i += 2;
                }else {
                    ans += 100;
                    i++;
                }
                } else {
                    ans += 100;
                    i++;
                }
            }else if (s.charAt(i)=='V'){
                ans+=5;
                i++;
            }else if (s.charAt(i)=='L'){
                ans+=50;
                i++;
            }else if (s.charAt(i)=='D'){
                ans+=500;
                i++;
            }else if (s.charAt(i)=='M'){
                ans+=1000;
                i++;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(toRoman("LVIII"));
    }
}
