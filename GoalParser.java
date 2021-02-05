public class GoalParser {

    public static String interpret(String command){

        String ans="";
        int i=0;
        while (i<command.length()){
            if (command.charAt(i)=='G'){
                ans+='G';
                i++;
            }
            else if (command.charAt(i)=='('){
                if (command.charAt(i+1)==')'){
                    ans+='o';
                    i+=2;
                }else{
                    ans+="al";
                    i+=4;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(interpret("(al)G(al)()()G"));
    }
}
