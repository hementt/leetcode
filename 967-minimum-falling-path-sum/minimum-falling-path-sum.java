class Solution {
    Integer dp[][];
    public int minFallingPathSum(int[][] matrix) {
        dp = new Integer[matrix.length][matrix.length];
        int ans = Integer.MAX_VALUE;
        for(int i =0; i<matrix.length;i++) ans = Math.min(ans , solve(0,i,matrix));
        return ans;
    }
    public int solve(int i, int j, int matrix[][]){
        if(i == matrix.length) return 0;
        if(j < 0 || j >= matrix[0].length) return (int) 1e9;

        if(dp[i][j] != null) return dp[i][j];

        int left = matrix[i][j] + solve(i+1, j-1, matrix);
        int right = matrix[i][j] + solve(i+1, j+1, matrix);
        int mid = matrix[i][j] + solve( i+1, j, matrix);

        return dp[i][j] = Math.min(left, Math.min(right, mid));
    }
}