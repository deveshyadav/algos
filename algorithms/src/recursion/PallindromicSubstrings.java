package recursion;

import java.util.ArrayList;

public class PallindromicSubstrings {

    public static void main(String[] args) {
        String s= "madam";
        ArrayList<String> res = partitions(s);
        System.out.println(res);
    }

    private static ArrayList<String> partitions(String s) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), res);
        return res;
    }

    private static void backtrack(String s, int start, StringBuilder temp, ArrayList<String> res) {
        if(start == s.length()){
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }

        for(int i = start;i<s.length();i++){
            String sub = s.substring(start,i+1);
            if(isPallindrome(sub)){
                int len = temp.length();
                temp.append(sub).append("|");
                backtrack(s ,i+1, temp, res);
                temp.delete(len ,temp.length());
            }
        }
    }

    static boolean isPallindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
