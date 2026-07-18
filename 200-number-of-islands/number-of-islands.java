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
    public  void bfs(char[][] grid, int currRow, int currCol, int totalRow, int totalCol){
        Queue <Pair> q = new LinkedList<>();
        Pair p = new Pair(currRow, currCol);
        q.add(p);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currPairRow = curr.row;
            int currPairCol = curr.col;

            for(int i =0; i<4;i++){
                int newRow = currPairRow + rowDirection[i];
                int newCol = currPairCol + colDirection[i];

                if(isValid(newRow, newCol, totalRow, totalCol)&& grid[newRow][newCol] == '1'){
                    grid[newRow][newCol] = '2';
                    Pair temp = new Pair(newRow, newCol);
                    q.add(temp);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i =0;i<n;i++){
            for(int j =0; j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j, n, m);
                }
            }
        }
        return count;
    }
}