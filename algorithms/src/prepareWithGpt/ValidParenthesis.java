package prepareWithGpt;

import java.util.List;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String par = "[{}}";
        boolean validPar = checkValidity(par);
        System.out.println(validPar);
    }

    private static boolean checkValidity(String par) {
        List<Character> openPar = List.of('[','{','(');
        List<Character> closedPar = List.of(']','}',')');
        char[] arr = par.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c:arr){
            if(openPar.contains(c)){
                stack.push(c);
            } else if(closedPar.contains(c)){
                if(stack.isEmpty()) return false;
                Character temp = stack.pop();
                if((c==']' && '[' != temp)){
                    return false;
                }
                if((c=='}' && '{' != temp)){
                    return false;
                }
                if (c==')' && '(' != temp){
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}
