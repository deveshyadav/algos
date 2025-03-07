import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSumSubsetsDP {
    
    // Main function that returns all subsets with the target sum.
    public static List<List<Integer>> findSubsets(int[] arr, int target) {
        Map<String, List<List<Integer>>> memo = new HashMap<>();
        List<List<Integer>> allSubsets = findSubsets(arr, target, 0, memo);
        
        // Remove empty subset if present (as per condition)
        allSubsets.removeIf(List::isEmpty);
        return allSubsets;
    }
    
    // Recursive DP function with memoization.
    private static List<List<Integer>> findSubsets(int[] arr, int target, int index,
                                                   Map<String, List<List<Integer>>> memo) {
        String key = index + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        // If we've processed all elements...
        if (index == arr.length) {
            // Only if target is exactly 0, add the empty subset (will be filtered later)
            if (target == 0) {
                result.add(new ArrayList<>());
            }
            memo.put(key, result);
            return result;
        }
        
        // 1. Option: Include the current element.
        List<List<Integer>> include = findSubsets(arr, target - arr[index], index + 1, memo);
        for (List<Integer> subset : include) {
            List<Integer> newSubset = new ArrayList<>();
            newSubset.add(arr[index]);
            newSubset.addAll(subset);
            result.add(newSubset);
        }
        
        // 2. Option: Exclude the current element.
        List<List<Integer>> exclude = findSubsets(arr, target, index + 1, memo);
        result.addAll(exclude);
        
        memo.put(key, result);
        return result;
    }
    
    // Example usage.
    public static void main(String[] args) {
        int[] arr = {1, -1, 2, 3};
        int target = 3;
        System.out.println("Subsets (using DP with memoization):");
        List<List<Integer>> subsets = findSubsets(arr, target);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
