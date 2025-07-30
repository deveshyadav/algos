package monthmarathon.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1,4,2,5,8,12};
        int target = 10;
        int minCoins = getMinCoins(coins, target);
        System.out.println(minCoins);
    }

    private static int getMinCoins(int[] coins, int target) {
        int max = target+1; // take as infinite
        int[] dp = new int[target+1];
        Arrays.fill(dp,max);

        dp[0]=0;

        for(int i=1;i<=target;i++){
            for(int coin:coins){
                if(i>=coin)
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }

        return dp[target] == max ? -1 : dp[target];
    }
}
