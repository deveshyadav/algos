package monthmarathon.leetcode.sliding_window.twentyone_june;

import java.util.stream.Stream;

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
            if(right >= k){
                curSum = curSum - nums[left];
                left++;
            }
            if (right > k-1) {
                maxAvg = Math.max((double) curSum / k, maxAvg);
            }
            right++;
        }

        return maxAvg;
    }

}
