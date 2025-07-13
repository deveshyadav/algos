package monthmarathon.leetcode.TwoPointer.fifteen_june;

import java.util.*;

/**
 * Find all unique triplets in the array that sum to 0 (or any target)
 * Time: O(n²), Space: O(1) — Sort + two-pointer per fixed element
 * Skips duplicates using sorted array to ensure unique triplets
 *
 * Alt: Use HashMap-based 2Sum for each fixed element → Time: O(n²), Space: O(n)
 *   (but requires extra deduplication logic due to unordered triplet combinations)
 */
public class ThreeNumberSumTarget {

    public static void main(String[] args) {
        int[] arr =  new int[]{2,4,10,-6,-1,-9};
        List<List<Integer>> cont = twoSum(arr,6);
        System.out.println("Triplets-  " + cont);
    }

    private static List<List<Integer>> getTarget(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    res.add(new ArrayList<>(Arrays.asList(arr[i], arr[left], arr[right])));
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }


    /**
     * Alternative way
     * @param arr
     * @param target
     * @return
     */
    private static List<List<Integer>> threeSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;

            int finalI = i;
            List<List<Integer>> temp = new ArrayList<>(twoSum(arr, target - arr[i]));

            temp.forEach(x -> {
                x.add(0,arr[finalI]);
            });
            res.addAll(temp);
        }

        return res;
    }



    private static List<List<Integer>> twoSum(int[] arr, int target){
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int j : arr) {
            if (seen.containsKey(target - j)) {
                List<Integer> temp = new ArrayList<>(List.of(j, target - j));
                if(!res.contains(temp)) {
                    res.add(temp);
                }
            } else {
                seen.put(j , 1);
            }
        }
        return res;
    }


}
