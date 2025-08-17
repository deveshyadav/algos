package recursion;

import java.util.*;

public class TargetSumSubsets {
    public static List<List<Integer>> findSubsets(int[] arr, int target) {
        Map<Long, List<List<Integer>>> memo = new HashMap<>();
        return dfs(arr, 0, target, memo);
    }

    private static List<List<Integer>> dfs(int[] arr, int i, int target, Map<Long, List<List<Integer>>> memo) {
        long key = (((long) i) << 32) ^ target;
        if (memo.containsKey(key)) return memo.get(key);

        List<List<Integer>> res = new ArrayList<>();
        if (i == arr.length) {
            if (target == 0) res.add(Collections.emptyList());
            memo.put(key, res);
            return res;
        }

        List<List<Integer>> include = dfs(arr, i + 1, target - arr[i], memo);
        if (!include.isEmpty()) {
            for (List<Integer> s : include) {
                List<Integer> ns = new ArrayList<>(s.size() + 1);
                ns.add(arr[i]);
                ns.addAll(s);
                res.add(ns);
            }
        }

        List<List<Integer>> exclude = dfs(arr, i + 1, target, memo);
        if (!exclude.isEmpty()) res.addAll(exclude);

        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 2, 3};
        int target = 3;
        List<List<Integer>> subsets = findSubsets(arr, target);
        for (List<Integer> subset : subsets) System.out.println(subset);
    }
}
