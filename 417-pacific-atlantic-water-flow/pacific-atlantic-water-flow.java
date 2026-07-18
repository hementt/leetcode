class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] rowDirection = {1, -1, 0, 0};
    int[] colDirection = {0, 0, 1, -1};

    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public void bfs(int[][] heights, int i, int j, boolean[][] ocean) {
        int n = heights.length;
        int m = heights[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        ocean[i][j] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int row = curr.row;
            int col = curr.col;

            for (int k = 0; k < 4; k++) {
                int newRow = row + rowDirection[k];
                int newCol = col + colDirection[k];

                if (isValid(newRow, newCol, n, m)
                        && !ocean[newRow][newCol]
                        && heights[newRow][newCol] >= heights[row][col]) {

                    ocean[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            bfs(heights, i, 0, pacific);
            bfs(heights, i, m - 1, atlantic);
        }

        for (int j = 0; j < m; j++) {
            bfs(heights, 0, j, pacific);
            bfs(heights, n - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}