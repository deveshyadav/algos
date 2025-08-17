package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Test1 {
    public static void main(String[] args) {
        String str = "abbsdccfghh";
        String res = getLongestUniqueString(str);
        System.out.println(res);
    }

    private static String getLongestUniqueString(String str) {

        int start=0;
        int end=0;
        int maxLen = 0;
        Map<Character,Integer> freq = new HashMap<>();

        int maxInd=0;

        for(int i=0;i<str.length();i++)
        {
            Integer f = freq.get(str.charAt(i));
            if(f!=null && f>0){
                start=i;
            } else{
                freq.put(str.charAt(i), 1);
                end++;
            }
            if(end-start+1>maxLen){
                maxInd = start;
                maxLen = end-start+1;
            }
        }

        return str.substring(maxInd,maxInd+maxLen);
    }
}
