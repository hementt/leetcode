class Solution {
    class Pair{
        int row;
        int col;
        int h;
        Pair(int row, int col, int h){
            this.row = row;
            this.col = col;
            this.h = h;
        }
    }
    int rowDir [] = {-1,1,0,0};
    int colDir [] = {0,0,-1,1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<Pair> q = new LinkedList <>();
        q.add(new Pair(0, 0, grid.get(0).get(0)));
        int isVis[][] = new int[n][m];
        for(int[] num : isVis){
            Arrays.fill(num, Integer.MAX_VALUE);
        }

        isVis[0][0] = grid.get(0).get(0);
        

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int h = curr.h;

            if((health - h) >= 1 && row == n-1 && col == m-1) return true;

            for(int i =0; i<4; i++){
                int cr = row + rowDir[i];
                int cl = col + colDir[i];

                if(cr >= 0 && cl >= 0 && cr <n && cl < m){
                    if(grid.get(cr).get(cl) + h < isVis[cr][cl]){
                        if(health - (h + grid.get(cr).get(cl)) >= 1){
                            q.add(new Pair(cr, cl, h +  grid.get(cr).get(cl)));
                            isVis[cr][cl] = h + grid.get(cr).get(cl);
                        }

                    }
                }
                
            }
        }
        return false;
    }
}