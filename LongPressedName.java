public class LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {
        if (typed.length()<name.length())
            return false;
        int nameInd=0;
        for (int i = 0; i < typed.length(); i++) {
            if (nameInd==name.length()){
                if (typed.charAt(i)!=typed.charAt(i-1)){
                    return false;
                }
            }
            else if (typed.charAt(i)==name.charAt(nameInd)){
                nameInd++;
            }
            else{
                if (i==0)
                    return false;
                if (typed.charAt(i)!=typed.charAt(i-1)){
                    return false;
                }
            }
        }
        if (nameInd!=name.length())
            return false;
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("saeed","ssaaedd"));
        System.out.println(isLongPressedName("leelee","lleeelee"));
        System.out.println(isLongPressedName("vt","vvv"));
    }
}
