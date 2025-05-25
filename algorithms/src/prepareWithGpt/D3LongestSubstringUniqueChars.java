package prepareWithGpt;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class D3LongestSubstringUniqueChars {

    public static void main(String[] args) {
        String inp = "abba";
        int out = lengthOfLongestSubstring(inp);
        System.out.println(out);
    }

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!seen.contains(c)) {
                seen.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }

}
