class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> list= new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        int size = (n-1) + (m - 1);
        for(int i =0; i<=size;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int idx = i + j;
                list.get(idx).add(mat[i][j]);
            }
        }

        int[] ans = new int[n*m];
        int k =0;
        for(int i =0; i<list.size();i++){
            if(i % 2 == 0) Collections.reverse(list.get(i));
            for(int j =0; j<list.get(i).size();j++){
                ans[k++] = list.get(i).get(j);
            }
        }
        return ans;
    }
}