import java.util.ArrayList;
import java.util.List;

public class TargetSumSubsetsRecursion {
    
    // Main recursive function that prints all valid subsets.
    public static void findSubsets(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findSubsetsHelper(arr, target, 0, current, result);
        
        // Print each non-empty subset
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
    
    // Recursive helper: index tracks our position in the array.
    private static void findSubsetsHelper(int[] arr, int target, int index,
                                          List<Integer> current, List<List<Integer>> result) {
        // Base condition: all elements processed.
        if (index == arr.length) {
            // Check if target reached and subset is nonempty.
            if (target == 0 && !current.isEmpty()) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        
        // Choose the current element.
        current.add(arr[index]);
        findSubsetsHelper(arr, target - arr[index], index + 1, current, result);
        
        // Backtrack: remove the current element and try without it.
        current.remove(current.size() - 1);
        findSubsetsHelper(arr, target, index + 1, current, result);
    }
    
    // Example usage.
    public static void main(String[] args) {
        int[] arr = {1, -1, 2, 3};
        int target = 3;
        System.out.println("Subsets (using recursion):");
        findSubsets(arr, target);
    }
}
