package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TargetSumSubsetsRecursion {


    // Recursive helper: index tracks our position in the array.
    private static void findSubsetsHelper(ArrayList<Integer> arr, int target, int index,
                                          ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // Base condition: all elements processed.
        if (index == arr.size()) {
            // Check if target reached and subset is nonempty.
            if (target == 0 && !current.isEmpty()) {
                Collections.sort(current);
                result.add(new ArrayList<>(current));
            }
            return;
        }
        
        // Choose the current element.
        current.add(arr.get(index));
        findSubsetsHelper(arr, target - arr.get(index), index + 1, current, result);
        
        // Backtrack: remove the current element and try without it.
        current.remove(current.size() - 1);
        findSubsetsHelper(arr, target, index + 1, current, result);
    }
    
    // Example usage.
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList(List.of(1,-1,2,3));
        int target = 3;
        System.out.println("Subsets (using recursion):");
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        findSubsetsHelper(arr, target, 0, current, result);

        // Print each non-empty subset
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
