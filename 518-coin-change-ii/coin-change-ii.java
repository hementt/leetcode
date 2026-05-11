class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];

        for(int i = 0;i<= coins.length;i++) dp[i][0] = 1;

        for(int i = coins.length-1;i>=0;i--){
            for(int j = 0;j<=amount;j++){

                int skip = dp[i+1][j];

                int take = 0;

                if(coins[i] <= j) take =dp[i][j - coins[i]];

                dp[i][j] = take + skip;
            }
        }

        return  dp[0][amount];

    }
}