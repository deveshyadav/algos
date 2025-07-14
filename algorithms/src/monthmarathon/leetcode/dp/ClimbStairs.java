package monthmarathon.leetcode.dp;

/**
 * Count distinct ways to climb stairs with 1 or 2 steps at a time
 * Time: O(n), Space: O(1) — Bottom-up DP using two variables (Fibonacci-style)
 * Track only last two results: a = dp[i-2], b = dp[i-1], update as a + b
 * Problem: LeetCode 70 — Climbing Stairs
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int totalSteps = 5;
        int ways = getNumberOfWaysToClimbWithDP(totalSteps);
        System.out.println("Total ways: "+ways);
    }

    private static int getNumberOfWaysToClimbWithDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //without DP simple space O(1)
    private static int getNumberOfWaysToClimb(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }




}
