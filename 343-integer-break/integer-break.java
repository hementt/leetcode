class Solution {
    Integer dp[][];
    public int integerBreak(int n) {
        dp = new Integer[n+1][n+1];
        return solve(n, n, 1);
    }
    public int solve(int n, int target ,int i){
        
        if(target == 0) return 1;
        if(i >=  n || target < 0) return 0;

        if(dp[i][target] != null) return dp[i][target];

        int include = i * solve(n, target - i, i);
        int exclude = solve(n, target, i+1);

        return dp[i][target] = Math.max(include, exclude);
    }
}