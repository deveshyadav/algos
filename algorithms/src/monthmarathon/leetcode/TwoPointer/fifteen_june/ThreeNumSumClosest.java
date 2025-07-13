package monthmarathon.leetcode.TwoPointer.fifteen_june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Find 3 integers in array whose sum is closest to the target
 * Time: O(n²), Space: O(1) — Sort + two-pointer for each fixed element
 * Keeps track of closest sum by comparing absolute differences
 *
 * Alt: Brute-force check all triplets → Time: O(n³), Space: O(1)
 */
public class ThreeNumSumClosest {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int target = 7;
        Arrays.sort(arr);
        ArrayList<Integer> input  = new ArrayList<>(IntStream.of(arr).boxed().toList());
        int res = getRes(input, target);
        System.out.println("Result is-"+res);
    }

    private static int getRes(ArrayList<Integer> input, int target) {
        Collections.sort(input); // Required for two-pointer logic
        int n = input.size();
        int bestSum = input.get(0) + input.get(1) + input.get(2);
        int bestDiff = Math.abs(target - bestSum);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = input.get(i) + input.get(left) + input.get(right);
                int diff = Math.abs(target - sum);

                if (diff < bestDiff) {
                    bestDiff = diff;
                    bestSum = sum;
                }

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum; // Exact match
                }
            }
        }

        return bestSum;
    }


}
