class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        bfs(image, sr, sc, color);
        return image;
        
    }
    int rd[] = {-1,1,0,0};
    int cd []= {0,0,-1,1};
    public void bfs(int[][] grid, int row, int col, int color){
        int n = grid.length;
        int m = grid[0].length;
        int target = grid[row][col];
        boolean isVis[][] = new boolean[n][m];
        grid[row][col] = color;

        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;

            for(int i =0; i<4;i++){
                int newRow = r + rd[i];
                int newCol = c + cd[i];

                if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m){
                    if(grid[newRow][newCol] == target && !isVis[newRow][newCol]){
                        grid[newRow][newCol] = color;
                        isVis[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }
}