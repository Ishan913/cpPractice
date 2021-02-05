import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s){
        Stack<Character> stack  =new Stack<>();
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{' )
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                if (s.charAt(i)==')'){
                    if (stack.pop()!='(')
                        return false;
                }else if (s.charAt(i)=='}'){
                    if (stack.pop()!='{')
                        return false;
                }else if (s.charAt(i)==']'){
                    if (stack.pop()!='[')
                        return false;
                }

            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("}"));
    }
}
