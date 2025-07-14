package monthmarathon.leetcode.dp;


/**
 * Return minimum number of operations (insert, delete, replace) to convert one string to another
 * Time: O(m × n), Space: O(m × n) — Bottom-up DP table where dp[i][j] is min operations to convert word1[0..i-1] to word2[0..j-1]
 * If chars match, take diagonal value; else take min of insert, delete, replace
 * Problem: LeetCode 72 — Edit Distance
 */
public class ConvertWord1ToWord2 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int count = getNumberOfOperations(word1, word2);
        System.out.println("Steps to convert: "+count);
    }

    private static int getNumberOfOperations(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0] = i;
        for(int j=0;j<=n;j++) dp[0][j] = j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    //min(Delete,Insert,Replace)
                    //Delete-> 1 char deleted from w1, compare i-1 w1 with j w1
                    //Insert-> 1 char inserted to w1, compare i w1 with j-1 w2
                    //Replace-> 1 char replaced in w1 from w2, compare rest means w1 i-1 to w2 j-1
                }
            }
        }
        return dp[m][n];
    }


}
