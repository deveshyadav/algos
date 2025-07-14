package monthmarathon.leetcode.dp;

/**
 * Problem: Minimum Path Sum in a Grid
 * Description: Given a 2D grid of delay times, find the minimum delay from top-left to bottom-right, moving only right or down.
 * Approach: Dynamic Programming
 * Logic: dp[i][j] = nodes[i][j] + min(dp[i-1][j], dp[i][j-1])
 * Base cases:
 *   - First row: only move right
 *   - First column: only move down
 * Time: O(m * n) — where m = rows, n = columns
 * Space: O(m * n) — DP matrix
 * Use when: Grid path problems with movement constraints (right/down)
 * Related: LeetCode 64 — Minimum Path Sum
 */
public class MinPathSumBasicDP {
    public static void main(String[] args) {
        int[][] nodes = new int[][]{{1,3,1},{1,5,1},{3,4,1}};
        int res = minPathSum(nodes);
        System.out.println(res);
    }

    private static int minPathSum(int[][] nodes) {

        int a = nodes.length;
        int b =nodes[0].length;
        int[][] dp = new int[a+1][b+1];

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(i==0 && j==0){ // Starting cell: no previous path, initialize with its own value
                    dp[i][j] = nodes[i][j];

                } else if (i==0) { // First row: can only come from the left
                    dp[i][j] = dp[i][j-1] + nodes[i][j];

                } else if (j==0) { // First column: can only come from the top
                    dp[i][j] = dp[i-1][j]+ nodes[i][j];

                } else {
                    dp[i][j] = nodes[i][j] + Math.min(dp[i-1][j], dp[i][j-1]); //General case: take min path from top or left cell
                }
            }

        }
        return dp[a-1][b-1];

    }
}
