package monthmarathon.leetcode.dp;

public class Robbing {
    public static void main(String[] args) {
        int[] moneys = new int[]{2,1,1,9};
        int maxMoney = getMostCash(moneys);
        System.out.println("Most cash: "+maxMoney);
    }

    private static int getMostCash(int[] moneys) {
        int n = moneys.length;
        if(n==1) return moneys[0];
        int[] dp = new int[n];
        dp[0] = moneys[0];
        dp[1] = Math.max(moneys[0],moneys[1]);

        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+moneys[i]);
        }
        return dp[n-1];
    }

}
