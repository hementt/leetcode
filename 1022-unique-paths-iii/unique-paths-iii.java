class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = m-1;
        int safe = 0;
        int obstacles =0;

        for(int i =0; i<n;i++){
            for(int j =0; j<m;j++){
                if(grid[i][j] == 1){startRow = i; startCol = j;}
                if(grid[i][j] == 2){endRow = i; endCol = j;}
                if(grid[i][j] == 0) safe++;
                if(grid[i][j] == -1) obstacles++;
            }
        }
        return solve(startRow, startCol, endRow, endCol, safe, grid);
    }
    public int solve(int i, int j, int n, int m, int safe, int grid[][]){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if(grid[i][j] == -1) return 0;

        if(i == n && j == m) {
            return safe == -1 ? 1 : 0;
        }
        
        int temp = grid[i][j];
        grid[i][j] = -1;
        int up = solve(i+1, j, n, m, safe - 1, grid);
        int down = solve(i, j+1, n, m,safe - 1,  grid);
        int right = solve(i-1 , j, n, m,safe - 1,  grid);
        int left = solve(i, j-1, n, m,safe - 1, grid);

        grid[i][j] = temp;

        return up + down + left + right;
    }
}