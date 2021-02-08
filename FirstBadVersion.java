public class FirstBadVersion {

    public static boolean isBadVersion(int version){
        return true;
    }

    public static int firstBadVersion(int n) {
        int first=1;
        int last=n;
        while (first<=last){
            int mid=first/2+last/2;
            if (isBadVersion(mid)){
                last=mid;
            }else {
                first=mid+1;
            }
        }
        return last;


    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));
    }
}

