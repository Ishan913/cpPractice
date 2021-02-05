import java.util.ArrayList;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        ArrayList<String> list = new ArrayList<String>();
        int i=0;
        int index1=0;
        int index2=0;
        while (index1!=-1){
            index1 = path.indexOf('/',i);
            index2=path.indexOf('/',index1+1);
            String temp="";
            if (index2==-1){
                temp =path.substring(index1);
            }
            else
                temp = path.substring(index1,index2);
            if (temp.equals("/..")){
                if (list.size()!=0)
                    list.remove(list.size()-1);
            }else if (temp.equals("/.") || temp.equals("/")){

            }else{
                list.add(temp);
            }
            i=index1+1;
            index1=index2;
        }
        if (list.isEmpty())
            return "/";
        return String.join("",list);
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b/c/d/././/.."));
    }
}
