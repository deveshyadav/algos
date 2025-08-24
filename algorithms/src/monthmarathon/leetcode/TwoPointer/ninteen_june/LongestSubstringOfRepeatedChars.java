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
        String str = "ABBAACDE";
        int k=1;
        int max = getLongestRepeat(str ,k);
        System.out.println("Result:-" + max);
    }



    private static int getLongestRepeat1(String str, int k) {
        int maxcount = 0;
        int maxLength=0;
        int[] freq =  new int[26];
        char[] arr = str.toCharArray();
        int n=arr.length;
        int left=0;
        for(int right=0;right<n;right++){
            char c = arr[right];
            freq[c-'A']++;
            maxcount = Math.max(freq[c-'A'], maxcount);

            while(right-left+1-maxcount>k){
                freq[arr[left]-'A']--;
                left++;
            }


            maxLength = Math.max(maxLength,right-left+1);


        }





return maxLength;

    }




    private static int getLongestRepeat(String str, int k) {
        int left = 0;
        int maxLen = 0;
        int maxCount = 0;
        int[] freq = new int[26]; // frequency of each uppercase letter

        for (int right = 0; right < str.length(); right++) {
            freq[str.charAt(right) - 'A']++; // update frequency for current character
            maxCount = Math.max(maxCount, freq[str.charAt(right) - 'A']); // track most frequent character in window

            // if window size minus maxCount > k, we have more than k characters to change
            while (right - left + 1 - maxCount > k) {
                freq[str.charAt(left) - 'A']--; // shrink window from left
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1); // update max length of valid window
        }

        return maxLen;
    }

}
