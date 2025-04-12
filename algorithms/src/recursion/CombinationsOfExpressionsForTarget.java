package recursion;

import java.util.ArrayList;

public class CombinationsOfExpressionsForTarget {
    public static void main(String[] args) {
        String str = "202";
        ArrayList<String> res = new ArrayList<>();
        backtrack(res, str, "",0, 4, 0, 0);
        System.out.println(res);
    }

    static void backtrack(ArrayList<String> result, String num, String exp, int pos, int target, long eval, long prev){
        if(pos == num.length() && target == eval && !result.contains(exp)){
            result.add(exp);
            return;
        }
        for(int i=pos;i<num.length();i++){
            String sub = num.substring(pos, i+1);
            long curr =  Long.parseLong(sub);
            if(pos==0){
                backtrack(result, num, exp+sub, i+1, target, curr, curr);
            }else {
                backtrack(result, num, exp + "+" + sub, i + 1, target, eval + curr, curr);
                backtrack(result, num, exp + "*" + sub, i + 1, target, eval - prev + (prev * curr), curr * prev);
                //backtrack(result, num, exp + "" + sub, i + 1, target, eval- prev +(eval * 10 + curr), prev * 10 + curr);
            }
        }

    }
}


