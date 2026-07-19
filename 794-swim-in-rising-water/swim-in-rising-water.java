class Solution {
    class Pair{
        int row;
        int col;
        int weight;
        
        Pair(int row, int col, int weight){
            this.row= row;
            this.col = col;
            this.weight = weight;
        }
    }

    int rowDirection[] = {0,0,-1,1};
    int colDirection[] = {-1, 1, 0,0};
    public boolean isValid(int i, int j, int n, int m){
        if(i>= 0 && j >= 0 && i < n && j < m){
            return true;
        }
        return false;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int path [][] = new int[n][m];
        for(int k[] : path){
            Arrays.fill(k, Integer.MAX_VALUE);
        }

        PriorityQueue <Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(0, 0, grid[0][0]));
        path[0][0] = grid[0][0];
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int w = curr.weight;
            if(r == n-1 && c == m-1){
                return path[n-1][m-1];
            }
            for(int i =0;i<4;i++){
                int newRow = r + rowDirection[i];
                int newCol = c + colDirection[i];
                
                if(isValid(newRow, newCol, n , m)){
                int max = Math.max(w , grid[newRow][newCol]);    
                    if(path[newRow][newCol] > max){
                        path[newRow][newCol] = max;
                        pq.add(new Pair(newRow, newCol, max));
                    }
                }
            }
        }
        return -1;
    }
    
}