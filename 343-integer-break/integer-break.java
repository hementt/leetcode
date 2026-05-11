class Solution {
    public int integerBreak(int n) {
        
        int dp[][] = new int[n+1][n+1];

        for(int i =0; i<=n;i++) dp[i][0] = 1;

        for(int i = n-1;i>=1;i--){
            for(int j =1; j<=n; j++){

                int exclude = dp[i+1][j];

                int include =0;
                if(j >= i) include = i * dp[i][j - i];

                dp[i][j] = Math.max(include , exclude);
            }
        }

        return dp[1][n];

    }
}