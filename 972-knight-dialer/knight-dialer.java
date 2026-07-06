class Solution {
    int[][] directions = {
    {-2, -1}, {-2, 1},
    {-1, -2}, {-1, 2},
    {1, -2},  {1, 2},
    {2, -1},  {2, 1}
    };

    int row = 4;
    int col = 3;
    int mod = (int) 1e9 + 7;
    Integer dp[][][];
    public int knightDialer(int n) {
        dp = new Integer[row][col][n];
        long res = 0;
        for(int i =0; i<row;i++){
            for(int j =0; j<col;j++){
                res += solve(i, j, n-1);
            }
        }

        return (int)(res%mod);
    }
    public int solve(int i, int j, int moves){
        if(i <= -1 || j <= -1 || i >= row || j >= col) return 0;
        if(i == row - 1 && (j == 0 || j == 2)) return 0;

        if(moves == 0) return 1;

        if(dp[i][j][moves] != null) return dp[i][j][moves];
        int ans = 0;
        for(int [] dir : directions){
            int temp = solve(i + dir[0] , j + dir[1], moves -1);
            ans = (ans + temp) % mod;
        }

        return dp[i][j][moves] = ans % mod;
    }
}