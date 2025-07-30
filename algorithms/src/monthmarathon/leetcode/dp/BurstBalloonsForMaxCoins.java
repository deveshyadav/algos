package monthmarathon.leetcode.dp;

/**
 * Problem: Burst Balloons (LeetCode 312)
 * Goal: Find the maximum coins from bursting balloons wisely (each burst earns coins from nums[i-1] * nums[i] * nums[i+1])
 *
 * Approach: Bottom-up DP with interval segmentation
 * - Pad the input array with 1 at both ends to handle edge balloons
 * - dp[i][j] = max coins obtainable by bursting balloons between i and j (exclusive)
 * - Try all possible k as the last balloon to burst in (i, j), and combine:
 *   dp[i][j] = max(dp[i][k] + dp[k][j] + padded[i]*padded[k]*padded[j])
 *
 * Time Complexity: O(n^3) — 3 nested loops (length, i, k)
 * Space Complexity: O(n^2) — dp table of size (n+2) x (n+2)
 */
public class BurstBalloonsForMaxCoins {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,8};
        int maxRes = getMaxRes(arr);
        System.out.println("Max output can be: " + maxRes);
    }

    private static int getMaxRes(int[] arr) {

        int n = arr.length;

        // Create a padded array with virtual balloons of value 1 at both ends.
        // This handles edge cases where a balloon is at the beginning or end
        // of the original array.
        // E.g., if nums = [3, 1, 5, 8], padded_nums will be [1, 3, 1, 5, 8, 1].
        int[] paddedNums = new int[n + 2];
        paddedNums[0] = 1;
        paddedNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            paddedNums[i + 1] = arr[i];
        }

        // dp[i][j] stores the maximum coins from bursting all balloons
        // strictly between index i and j (exclusive of i and j) in paddedNums.
        // The size of the dp table will be (n+2) x (n+2).
        int[][] dp = new int[n + 2][n + 2];

        // Iterate over the length of the subproblem (segment).
        // 'length' represents (j - i).
        // A minimum length of 2 is needed for a valid segment (i.e., at least one balloon to burst).
        // The maximum length is n + 1, covering all original balloons between the two virtual '1's.
        for (int length = 2; length <= n + 1; length++) {
            // Iterate over the starting index 'i' of the subproblem.
            // 'i' goes from 0 up to (n + 2 - length).
            // 'n + 2' is the total size of paddedNums.
            for (int i = 0; i <= (n + 1 - length); i++) {
                // Calculate the ending index 'j' for the current length.
                int j = i + length;

                // Iterate over 'k', which represents the last balloon to be burst
                // within the segment (i, j).
                // 'k' must be strictly between i and j.
                for (int k = i + 1; k < j; k++) {
                    // Calculate coins obtained when 'k' is the last balloon burst in (i, j).
                    // When 'k' is burst, 'paddedNums[i]' and 'paddedNums[j]' are its immediate neighbors.
                    int coinsForK = paddedNums[i] * paddedNums[k] * paddedNums[j];

                    // The total coins for this choice of 'k' are:
                    // (max coins from bursting balloons in (i, k))
                    // + (max coins from bursting balloons in (k, j))
                    // + (coins obtained by bursting 'k' itself)
                    int totalCoins = dp[i][k] + dp[k][j] + coinsForK;

                    // Update dp[i][j] with the maximum coins found so far for this segment.
                    dp[i][j] = Math.max(dp[i][j], totalCoins);
                    System.out.println("For i: "+i +" and j: "+j + " dp[i][j]: "+dp[i][j]);
                }
            }
        }

        // The result is stored in dp[0][n+1], which represents the maximum coins
        // from bursting all original balloons (between the two virtual 1s).
        return dp[0][n + 1];
    }
}
