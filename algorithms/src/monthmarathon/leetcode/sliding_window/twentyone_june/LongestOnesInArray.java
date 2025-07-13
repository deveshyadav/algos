package monthmarathon.leetcode.sliding_window.twentyone_june;

/**
 * Find the longest subarray with at most k zeros flipped to ones
 * Time: O(n), Space: O(1) — Sliding window with fixed-size freq array
 * Maintains max 1s count in window, allows at most k zero flips
 *
 * Alt: Brute-force all subarrays → Time: O(n²), Space: O(1)
 */
public class LongestOnesInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,1,1,0,0,1,1,0};
        int k=2;
        int longest = getLongestOnes(nums, k);
        System.out.println(longest);
    }

    private static int getLongestOnes(int[] nums, int k) {
        int[] freq = new int[2];
        int right =0;
        int left=0;
        int maxLen = 0;
        int maxCount = 0;
        while(right<nums.length){
            freq[nums[right]]++;
            maxCount = Math.max(maxCount,freq[1]);

            while(right -left+1 - maxCount > k){
                freq[nums[left]]--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right ++;

        }

        return maxLen;
    }


}
