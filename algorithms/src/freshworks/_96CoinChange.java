package freshworks;

import java.util.Arrays;

public class _96CoinChange {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5};
        int target = 11;
        int minCoins = getMinCoins1(target, arr);
        System.out.println(minCoins);
    }

    private static int getMinCoins1(int target, int[] arr) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,target+1);
        dp[0]=0;

        for(int i=1;i<=target;i++){
            for(int coin:arr){
                if(i>=coin){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }

        return dp[target] == target+1? -1:dp[target];
    }
}
