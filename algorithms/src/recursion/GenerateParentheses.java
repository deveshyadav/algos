package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        // We can add an opening parenthesis if we haven't reached the maximum.
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        // We can add a closing parenthesis only if it would not lead to invalid string.
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        int n = 3;
        List<String> validParentheses = generateParenthesis(n);
        System.out.println("Valid parentheses combinations for " + n + " pairs:");
        for (String s : validParentheses) {
            System.out.println(s);
        }
    }
}
