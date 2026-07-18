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
    boolean pacific[][];
    boolean atlantic[][];
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];

        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0; i<n;i++){
            bfs1(heights, i, 0);
            bfs2(heights, i, m-1);
        }
        for(int i =0;i<m;i++){
            bfs1(heights, 0, i);
            bfs2(heights, n-1, i);
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;

    }public void bfs1(int[][] heights, int i, int j){
        int n = heights.length;
        int m = heights[0].length;
        boolean isVis[][] = new boolean[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        isVis[i][j] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            pacific[row][col] = true;
            for(int k =0; k<4;k++){
                int newRow = row + rowDirection[k];
                int newCol = col + colDirection[k];

                if(isValid(newRow, newCol, n, m) && heights[newRow][newCol] >= heights[row][col] && !isVis[newRow][newCol]){
                    q.add(new Pair(newRow, newCol));
                    isVis[newRow][newCol] = true;
                }
            }
        }
    }public void bfs2(int[][] heights, int i, int j){
        int n = heights.length;
        int m = heights[0].length;
        boolean isVis[][] = new boolean[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        isVis[i][j] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            atlantic[row][col] = true;
            for(int k =0; k<4;k++){
                int newRow = row + rowDirection[k];
                int newCol = col + colDirection[k];

                if(isValid(newRow, newCol, n, m) && heights[newRow][newCol] >= heights[row][col] && !isVis[newRow][newCol]){
                    q.add(new Pair(newRow, newCol));
                    isVis[newRow][newCol] = true;
                }
            }
        }
    }
}