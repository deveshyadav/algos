package monthmarathon.leetcode.TwoPointer.fifteen_june;

import java.util.Arrays;

/**
 * Removes duplicates from sorted array, allowing at most 2 occurrences
 * Time: O(n), Space: O(1) — In-place overwrite using two-pointer technique
 * Compares with value (k - 1) positions behind to control duplicate count
 * Can be generalized to allow K duplicates with minor change
 */
public class RemoveDuplicatesFromArray2 {

    public static void main(String[] args) {
        int[] arr =  new int[]{1,1,1,1,2,2,2,3,4,5,5,5,5,5};
        int cont = removeDupli(arr);
        System.out.println("Required-  " + cont);
    }

    /**
     * Any element can occur at most twice
     * @param arr
     * @return
     */
    private static int removeDupli(int[] arr) {
        int n = arr.length;
        if (n <= 2) return n;
        int j = 1;
        for (int i = 2; i < n; i++) {
            if (arr[i] != arr[j - 1]) {
                j++;
                arr[j] = arr[i];
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOf(arr, j + 1)));
        return j + 1;
    }

}
