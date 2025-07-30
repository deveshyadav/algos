package monthmarathon.leetcode.dp;

/**
 * DP Solution
 * Time Complexity: O(n × target)
 * Space : O(n × target)
 */
public class SubsetArraysCountForTargetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7};
        int target  = 12;
        int subsetsCount = getSubsetsCount(arr,target);
        System.out.println(subsetsCount);
    }

    private static int getSubsetsCount(int[] arr, int target) {

        int n = arr.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i-1][j];

                if(j>=arr[i-1]){
                    dp[i][j]+= dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][target];
    }
}
