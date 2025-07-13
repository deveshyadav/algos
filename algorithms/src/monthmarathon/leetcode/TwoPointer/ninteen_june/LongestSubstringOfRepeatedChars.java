package monthmarathon.leetcode.TwoPointer.ninteen_june;

/**
 * Find longest substring where at most k characters can be replaced to make all characters equal
 * Time: O(n), Space: O(1) — Sliding window with freq array for A–Z
 * Keeps track of max repeating char in window; shrinks window when replacements exceed k
 *
 * Problem: Longest Repeating Character Replacement (LeetCode 424)
 */
public class LongestSubstringOfRepeatedChars {
    public static void main(String[] args) {
        String str = "AABAACDE";
        int k=1;
        int max = getLongestRepeat(str ,k);
        System.out.println("Result:-" + max);
    }

    private static int getLongestRepeat(String str, int k) {
        int left=0;
        int maxLen =0;
        int maxCount = 0;
        int[] freq = new int[26];

        for(int right=0;right<str.length();right++){
            freq[str.charAt(right)-'A']++;
            maxCount = Math.max(maxCount, freq[str.charAt(right)-'A']);

            while(right-left+1 - maxCount > k ){
                freq[str.charAt(left)-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
