package monthmarathon.leetcode.TwoPointer.sixteen_june;

import java.util.Arrays;

/**
 * Return sorted array of squares from sorted input (can have negatives)
 * Time: O(n), Space: O(n) — Two-pointer from ends, fill result from back
 * Compare squares at both ends and place larger one at end of result
 * Problem: LeetCode 977 — Squares of a Sorted Array
 */
public class GetSortedSquares {
    public static void main(String[] args) {
        int[] arr =  new int[]{-4,-2,-1,2,3};
        int[] cont = getSortedSqrs(arr);
        System.out.println("Result-  " + Arrays.toString(cont));
    }

    private static int[] getSortedSqrs(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int sleft = arr[left] * arr[left];
            int sright = arr[right] * arr[right];

            if (sleft < sright) {
                res[idx--] = sright;
                right--;
            } else {
                res[idx--] = sleft;
                left++;
            }
        }
        return res;
    }
}
