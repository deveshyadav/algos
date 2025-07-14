package monthmarathon.leetcode.dp;

/**
 * Return length of Longest Common Subsequence (LCS) between two strings
 * Time: O(m × n), Space: O(m × n) — Fill 2D DP table comparing characters of both strings
 * Use dp[i][j] to represent the LCS of t1[0..i-1] and t2[0..j-1].
 * Base case: LCS with empty string is 0.
 * If characters match: dp[i][j] = 1 + dp[i-1][j-1]
 * Else: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 * This handles all possibilities of skipping characters in either string.
 * Problem: LeetCode 1143 — Longest Common Subsequence
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String t1 = "text1";
        String t2 = "text2";

        int res = getLCS(t1, t2);
        System.out.println("Result: "+res);
    }

    private static int getLCS(String t1, String t2) {
        int m = t1.length();
        int n = t2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];

    }
}
