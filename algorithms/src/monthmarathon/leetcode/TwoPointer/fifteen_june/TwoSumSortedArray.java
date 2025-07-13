package monthmarathon.leetcode.TwoPointer.fifteen_june;

import java.util.*;

/**
 * Find pairs in array that sum to a target
 *
 * 1. HashMap-based approach (unsorted input)
 *    Time: O(n), Space: O(n) — Track complements using HashMap
 *
 * 2. Two-pointer approach (sorted input)
 *    Time: O(n log n) if sorting is needed, Space: O(1)
 */
public class TwoSumSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 11;

        // HashMap-based (unsorted)
        System.out.println("Pairs using HashMap:");
        List<List<Integer>> hashMapResult = twoSumUsingHashMap(arr, target);
        hashMapResult.forEach(System.out::println);

        // Two-pointer-based (sorted)
        System.out.println("First matching pair using Two-pointer:");
        int[] pair = get2SumUsingTwoPointer(target, arr);
        System.out.println(Arrays.toString(pair));
    }

    /**
     * Approach 1: HashMap — Works for unsorted array, finds all unique pairs
     */
    private static List<List<Integer>> twoSumUsingHashMap(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                List<Integer> pair = Arrays.asList(Math.min(num, complement), Math.max(num, complement));
                resultSet.add(pair);
            }
            seen.add(num);
        }

        return new ArrayList<>(resultSet);
    }

    /**
     * Approach 2: Two-pointer — Works for sorted array, returns first valid pair
     */
    private static int[] get2SumUsingTwoPointer(int target, int[] arr) {
        Arrays.sort(arr); // Sort array (modifies input)
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0]; // No pair found
    }
}
