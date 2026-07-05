class Solution {
    Integer dp[][][];
    public int cherryPickup(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return solve(0,0,grid[0].length-1, grid);
    }
    public int solve(int i, int j, int k, int grid[][]){
        if(i == grid.length) return 0;
        if(j < 0 || k < 0  || k == grid[0].length  || j == grid[0].length) return (int) -1e9;

        if(dp[i][j][k] != null) return dp[i][j][k];
        int cherry = (j == k) ? grid[i][j] : grid[i][j] + grid[i][k];

        int case1 = cherry + solve(i + 1, j , k, grid);
        int case2 = cherry + solve(i + 1, j, k+1, grid);
        int case3 = cherry + solve(i + 1, j , k - 1, grid);
        int case4 = cherry + solve(i + 1, j +1, k, grid);
        int case5 = cherry + solve(i + 1, j +1, k+1, grid);
        int case6 = cherry + solve(i + 1, j +1, k-1, grid);
        int case7 = cherry + solve(i + 1, j -1, k, grid);
        int case8 = cherry + solve(i + 1, j -1, k-1, grid);
        int case9 = cherry + solve(i + 1, j -1, k +1, grid);

        return dp[i][j][k] = Math.max(case1, Math.max(case2, Math.max(case3, Math.max(case4, Math.max(case5,
       Math.max(case6, Math.max(case7, Math.max(case8, case9))))))));
    }
}