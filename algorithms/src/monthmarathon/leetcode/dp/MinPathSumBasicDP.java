package monthmarathon.leetcode.dp;

public class MinPathSumBasicDP {
    public static void main(String[] args) {
        int[][] nodes = new int[][]{{1,3,1},{1,5,1},{3,4,1}};
        int n = 4;
        int k = 2;
        int res = getMinimumDelayTime(nodes, n, k);
        System.out.println(res);
    }

    private static int getMinimumDelayTime(int[][] nodes, int n, int k) {

        int a = nodes.length;
        int b =nodes[0].length;
        int[][] dp = new int[a+1][b+1];

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(i==0 && j==0){
                    dp[i][j] = nodes[i][j];
                } else if (i==0) {
                    dp[i][j] = dp[i][j-1] + nodes[i][j];
                } else if (j==0) {
                    dp[i][j] = dp[i-1][j]+ nodes[i][j];
                } else {
                    dp[i][j] = nodes[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        return dp[a-1][b-1];

    }
}
