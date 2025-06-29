package monthmarathon.leetcode.dp;

public class ClimbStairs {
    public static void main(String[] args) {
        int totalSteps = 5;
        int ways = getNumberOfWaysToClimb(totalSteps);
        System.out.println("Total ways: "+ways);
    }

    private static int getNumberOfWaysToClimb(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
