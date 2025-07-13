package monthmarathon.leetcode.sliding_window.twentyone_june;

/**
 * Find maximum average of any subarray of size k
 * Time: O(n), Space: O(1) — Sliding window sum over array
 * Maintains current sum of window, updates max average
 *
 * Alt: Brute-force each window → Time: O(n * k), Space: O(1)
 */
public class MaxSubArrayAvg1 {
    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int k=1;
        double maxAvg = getMaxAvg(nums, k);
        System.out.println(maxAvg);
    }

    private static double getMaxAvg(int[] nums, int k) {
        int left =0;
        int right =0;
        double maxAvg = Integer.MIN_VALUE;
        int curSum = 0;

        while(right<nums.length){
            curSum = curSum + nums[right];
            if(right >= k){//slide window
                curSum = curSum - nums[left];
                left++;
            }
            if (right > k-1) { //Use full window
                maxAvg = Math.max((double) curSum / k, maxAvg);
            }
            right++;
        }

        return maxAvg;
    }

}
