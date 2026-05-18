class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean isValid(int newRow, int newCol, int totalRow, int totalCol){
        if(newRow >= 0 && newRow< totalRow && newCol>=0 && newCol < totalCol){
            return true;
        }
        return false;
    }
    int[] rowDirection= {1,-1,0,0};
    int[] colDirection = {0,0,1,-1};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i =0; i<n;i++){
            for(int j =0; j<m; j++){
                if(mat[i][j] == 0) q.add(new Pair(i, j));
            }
        } 

        int step = 1;
        boolean isVis[][] = new boolean[n][m];
        while(!q.isEmpty()){
            bfs(mat, isVis, q, step);
            step++;
        }
        return mat;
    }
    public void bfs(int [][] grid, boolean isVis[][], Queue<Pair> q, int step){
        int n = grid.length;
        int m = grid[0].length;

        int size = q.size();
        while(size-- > 0){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            for(int i =0; i<4;i++){
                int newRow = row + rowDirection[i];
                int newCol = col + colDirection[i];

                if(isValid(newRow, newCol, n, m)){
                    if(grid[newRow][newCol] == 1 && !isVis[newRow][newCol]){
                        isVis[newRow][newCol] = true;
                        grid[newRow][newCol] = step;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
}