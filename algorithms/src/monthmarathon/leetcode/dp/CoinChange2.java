package monthmarathon.leetcode.dp;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins = new int[]{1,4,2,8,12};
        int target = 10;
        int minCoins = getMinCoins(coins, target);
        System.out.println(minCoins);
    }

    private static int getMinCoins(int[] coins, int target) {
        //int max = target+1; // take as infinite
        int[] dp = new int[target+1];
        //Arrays.fill(dp,max);

        dp[0]=1;

        for(int coin:coins){
            for(int i=coin;i<=target;i++){
                dp[i] += dp[i-coin];
            }
        }

        return dp[target];
    }
}
