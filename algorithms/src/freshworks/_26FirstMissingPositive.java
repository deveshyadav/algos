package freshworks;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class _26FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,4,3,6,1,0};
        int res  =firstMissingPositive(arr);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) {
            int v = nums[i];
            // Place v at its correct index v-1 if:
            // 1. v is in the valid range [1, n]
            // 2. v is not already in the correct position
            if (v >= 0 && v < n && nums[v] != v) {
                int tmp = nums[v];
                nums[v] = v;
                nums[i] = tmp;
            } else {
                i++;
            }
        }
        // First index i where nums[i] != i+1 is the missing positive
        for (i = 0; i < n; i++)
            if (nums[i] != i) return i;
        // If all positions are correct, missing is n+1

        String s = "";

        return n;
    }

}
