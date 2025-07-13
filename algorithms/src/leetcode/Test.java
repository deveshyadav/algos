package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String str = "aaaadff";
        String substr = getLSWR(str);
        System.out.println(substr);
    }

    private static String getLSWR(String str) {
        int left=0;
        Map<Character,Integer> map = new HashMap<>();
        int startIndex = 0;
        int maxC = 0;

        for(int right=0;right<str.length();right++){
            char cur = str.charAt(right);
            if(map.containsKey(cur) && map.get(cur)>=left){
                left = map.get(cur)+1;
            }
            map.put(cur,right);
            if(right-left+1>maxC){
                maxC = right-left+1;
                startIndex = left;
            }
        }

        return str.substring(startIndex, startIndex+maxC);
    }
}
