class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];

        for(int i = 1; i<= amount;i++) dp[coins.length][i] = (int) 1e5;

        for(int i = coins.length-1;i>=0;i--){
            for(int j = 0;j<=amount;j++){

                int skip = dp[i+1][j];

                int take = (int)1e5;;

                if(coins[i] <= j) take = 1 + dp[i][j - coins[i]];

                dp[i][j] = Math.min(skip, take);
            }
        }

        int ans = dp[0][amount];
        return ans >= 1e5 ? -1 : ans;
    }
}