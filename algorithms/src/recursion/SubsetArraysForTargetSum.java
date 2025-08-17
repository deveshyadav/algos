package recursion;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Recursive Solution
 * Time = O(2^n) for the no-repeat version.
 * Time = O(k^n) (pseudo-polynomial) for the reuse version, where k ≈ target / min(arr[i]).
 */
public class SubsetArraysForTargetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7};
        int target  =12;
        Set<List<Integer>> res = new HashSet<>();
        checkForSubsets(arr,res, 0, new ArrayList<>(),target);
        List<List<Integer>> res1= res.stream().toList();
        System.out.println(res1);
    }

    private static void checkForSubsets(int[] arr, Set<List<Integer>> res, int ind, List<Integer> curr,int target) {
        int sum  = Arrays.stream(arr).sum();
        if(sum>target) return;
        if(sum ==target ){
            List<Integer> temp = new ArrayList<>(curr);
            Collections.sort(temp);
            res.add(new ArrayList<>(temp));
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            curr.add(arr[i]);
            checkForSubsets(arr,res, i+1, curr,target);
            curr.removeLast();
        }
    }
}
