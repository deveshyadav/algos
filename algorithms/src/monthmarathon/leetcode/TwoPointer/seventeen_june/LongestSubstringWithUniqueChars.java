package monthmarathon.leetcode.TwoPointer.seventeen_june;

import java.util.HashMap;
import java.util.Map;

/**
 * Find length of longest substring with all unique characters (non-repeating)
 * Time: O(n), Space: O(n) — Sliding window with HashMap to track last seen index
 * On repeat within window, move left pointer to 1 past previous index
 *
 * Classic unique-substring problem (LeetCode 3)
 */
public class LongestSubstringWithUniqueChars {
    public static void main(String[] args) {
        String str = "aab";
        int cont = longestSubstring(str);
        System.out.println("Result-  " + cont);
    }

    private static int longestSubstring(String str) {
        Map<Character, Integer> map = new HashMap<>(); // stores last index of each character
        int maxLen = 0, start = 0;

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);

            // If character is repeated and its last index is within current window
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1; // move start to exclude previous occurrence
            }

            map.put(c, end); // update last index of current character
            maxLen = Math.max(maxLen, end - start + 1); // update max length of unique substring
        }

        return maxLen;
    }


}
