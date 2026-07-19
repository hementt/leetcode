class Solution {
    class Pair{
        int row;
        int col;
        int weight;
        
        Pair(int row,int col, int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }
    int rd[] = {0,0,1,-1};
    int cd[] = {1, -1, 0, 0};
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] ans = new int[n][m];
        for(int [] num: ans){
            Arrays.fill(num, Integer.MAX_VALUE);
        }
        ans[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(0, 0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int w = curr.weight;
            if(r == n-1 && c == m - 1) return w;
            for(int i =0; i<4;i++){
                int nr = r + rd[i];
                int nc = c + cd[i];
                int nw = w;
                if(nr < 0 || nr > n-1 || nc < 0 || nc > m-1) continue;
                
                if(grid[r][c] != i+1){
                    nw += 1;
                }

                if(nw < ans[nr][nc]){
                    ans[nr][nc] = nw;
                    pq.add(new Pair(nr,nc,nw));
                }
                
            }
        }
        return -1;
    }
}