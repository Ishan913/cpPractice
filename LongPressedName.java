public class LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {
        if (typed.length()<name.length())
            return false;
        int isEmpty=0;
        int rep = 0;
        int nameInd=0;
        for (int i = 0; i < typed.length(); i++) {
            if (typed.charAt(i)==name.charAt(nameInd)){
                i++;
                nameInd++;
            }
            else{
                
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("saeed","ssaaedd"));
        System.out.println(isLongPressedName("leelee","lleeelee"));
    }
}
