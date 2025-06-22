package monthmarathon.leetcode.TwoPointer.seventeen_june;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUniqueChars {
    public static void main(String[] args) {
        String str = "aab";
        int cont = longestSubstring(str);
        System.out.println("Result-  " + cont);
    }

    private static int longestSubstring(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        int maxlen = 0;
        int begin =0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int x = map.getOrDefault(arr[i],-1);
            if(x>=begin) {
                if (i - begin > maxlen) {
                    maxlen = i - begin;
                }
                begin = x + 1;
            }
            map.put(arr[i], i);

        }
        maxlen = Math.max(maxlen, n - begin);
        return maxlen;
    }
}
