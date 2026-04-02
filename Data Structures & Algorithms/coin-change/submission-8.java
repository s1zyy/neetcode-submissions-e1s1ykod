
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        
        for(int i = 1; i <= amount; i++) {
            for(int k = 0; k < coins.length; k++) {
                int coin = coins[k];
                if(i == coin) {
                    dp[i] = 1;
                } else if((i-coin) > 0) {
                    if(dp[i-coin]!=0){
                        dp[i] = dp[i] != 0 ? Math.min(dp[i-coin] + 1, dp[i]) : dp[i-coin] + 1;
                    }
                } else if((i-coin) < 0){
                    break;
                }
            }
        }
        return dp[amount] != 0 ? dp[amount] : -1;
        
    }
}
