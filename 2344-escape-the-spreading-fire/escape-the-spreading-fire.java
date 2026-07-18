class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    class Pair1 {
    int row;
    int col;
    int time;

    Pair1(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
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
    public int maximumMinutes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int temp[][] = new int[n][m];
        for(int num[] : temp) Arrays.fill(num, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        for(int i =0; i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j));
                    temp[i][j] = 0;
                }
            }
        }

        multiSource(q, temp,grid,  n, m);
        int canReach = -1;
        int left = 0;
        int right = n*m+1; 
        while(left <= right){
            int mid = left + (right - left)/2;

            if(bfs(grid, temp, n, m, mid)){
                canReach = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
            
        }

        return canReach == n*m+1 ? 1000000000 : canReach;
    }
public boolean bfs(int grid[][], int temp[][], int n, int m, int fireTime){
        Queue<Pair1> q = new LinkedList<>();
        boolean isVisited[][] = new boolean[n][m];

        q.add(new Pair1(0,0, fireTime));
        isVisited[0][0] = true;
        
        if (fireTime >= temp[0][0]) {
            return false;
        }   
        while(!q.isEmpty()){
            Pair1 curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int time = curr.time;
            if(r == n-1 && c == m-1) return true;

            for(int i =0;i<4;i++){
                int row = r + rowDirection[i];
                int col = c + colDirection[i];
                if(isValid(row, col, n, m) && grid[row][col] == 0 && !isVisited[row][col]){
                    if(row == n-1 && col == m-1) {
                        if(time + 1 <= temp[row][col]) {
                            return true;
                        }
                    }else if(time + 1 < temp[row][col]) {
                        isVisited[row][col] = true;
                        q.add(new Pair1(row, col, time+1));
                    }
                }
            }
        }
        return false;
    }

    public void multiSource(Queue <Pair> q, int fireTime[][] , int[][] grid, int n , int m){
        
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();

            while(size != 0){
                size--;
                Pair curr  = q.poll();
                int r = curr.row;
                int c = curr.col;

                for(int i =0; i<4;i++){
                    int newRow = r + rowDirection[i];
                    int newCol = c + colDirection[i];

                    if(isValid(newRow, newCol, n, m) &&  grid[newRow][newCol] != 2
                    && fireTime[newRow][newCol] == Integer.MAX_VALUE){
                        fireTime[newRow][newCol] = steps;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
            steps++;
        }

    }
}