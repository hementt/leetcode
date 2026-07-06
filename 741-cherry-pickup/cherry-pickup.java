class Solution {
    Integer dp[][][][];
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n][n][n];
        int ans =  solve(0,0,0,0,grid);
        return ans > 0 ? ans : 0;
        
    }
    public int solve(int i, int j, int k, int l, int[][] grid){
        if (i == grid.length - 1 && j == grid.length - 1 &&
            k == grid.length - 1 && l == grid.length-1) {
            return grid[i][j];
        }
        
        if(i == grid.length || j == grid[0].length) return (int) -1e9;
        if(k == grid.length || l == grid.length) return (int) -1e9;

        if(grid[i][j] == -1 || grid[k][l] == -1) return (int) -1e9;
        if(dp[i][j][k][l] != null) return dp[i][j][k][l];
        
        int cherry = (i == k && j == l) ? grid[i][j] : grid[i][j] + grid[k][l];
        int case1 = cherry + solve(i + 1, j, k+1, l, grid);
        int case2 = cherry + solve(i + 1, j, k, l+1, grid);
        int case3 = cherry + solve(i, j + 1, k + 1, l, grid);
        int case4 = cherry + solve(i, j+1, k, l+1, grid);

        return dp[i][j][k][l] = Math.max(case1, Math.max(case2, Math.max(case3, case4)));
    }
}