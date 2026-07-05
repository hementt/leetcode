class Solution {
    int mod = (int) 1e9 + 7;
    Integer dp[][][];
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove + 1];
        return solve(m, n, startRow, startColumn, maxMove);
    }
    public int solve(int m, int n, int i, int j, int maxMoves){
        if(i == -1 || j == -1 || i == m || j == n) return 1;

        if(maxMoves == 0) return 0;
        if(dp[i][j][maxMoves] != null) return dp[i][j][maxMoves];
        int top = solve(m, n, i+1, j, maxMoves-1);
        int down = solve(m, n, i-1, j, maxMoves-1);
        int right = solve(m, n, i, j+1, maxMoves-1);
        int left = solve(m, n, i, j-1, maxMoves-1);

        long ans = ((long)left + right + top + down) % mod;
        return dp[i][j][maxMoves]= (int) ans;
    }
}