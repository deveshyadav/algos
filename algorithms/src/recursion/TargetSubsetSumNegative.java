package recursion;

import java.util.ArrayList;
import java.util.List;

public class TargetSubsetSumNegative {

    public static boolean hasNonEmptySubsetSum(int[] nums, int target) {
        return hasNonEmptySubsetSumRecursive(nums, target, 0, 0);
    }

    private static boolean hasNonEmptySubsetSumRecursive(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            return currentSum == target && index > 0; // Check if target is met and subset is non-empty
        }

        // Include the current number
        if (hasNonEmptySubsetSumRecursive(nums, target, index + 1, currentSum + nums[index])) {
            return true;
        }

        // Exclude the current number
        if (hasNonEmptySubsetSumRecursive(nums, target, index + 1, currentSum)) {
            return true;
        }

        return false; // No subset found
    }

    public static List<Integer> findNonEmptySubset(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        if (findNonEmptySubsetRecursive(nums, target, 0, 0, subset)) {
            return subset;
        }
        return null; // Return null if no subset is found
    }

    private static boolean findNonEmptySubsetRecursive(int[] nums, int target, int index, int currentSum, List<Integer> subset) {
        if (index == nums.length) {
            if (currentSum == target && !subset.isEmpty()) {
                return true;
            }
            return false;
        }

        // Include the current number
        subset.add(nums[index]);
        if (findNonEmptySubsetRecursive(nums, target, index + 1, currentSum + nums[index], subset)) {
            return true;
        }
        subset.remove(subset.size() - 1); // Backtrack: remove the number

        // Exclude the current number
        if (findNonEmptySubsetRecursive(nums, target, index + 1, currentSum, subset)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, -4, 2, 5, -1};
        int target = 4;

        System.out.println("Has non-empty subset sum: " + hasNonEmptySubsetSum(nums, target));
        System.out.println("Non-empty subset: " + findNonEmptySubset(nums, target));

        int[] nums2 = {-1, -2, -3, -4, -5};
        int target2 = -6;

        System.out.println("Has non-empty subset sum 2: " + hasNonEmptySubsetSum(nums2, target2));
        System.out.println("Non-empty subset 2: " + findNonEmptySubset(nums2, target2));

        int[] nums3 = {1, 2, 3};
        int target3 = 0;
        System.out.println("Has non-empty subset sum 3: " + hasNonEmptySubsetSum(nums3, target3));
        System.out.println("Non-empty subset 3: " + findNonEmptySubset(nums3, target3));
    }
}
