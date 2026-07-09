class Solution {
    class DSU{
        int n;
        int [] parent;
        int []rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i =0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] == x) return x;

            return parent[x] = find(parent[x]);
        }

        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return;

            if(rank[pa] > rank[pb]){
                parent[pb] = pa;
            }else if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }else{
                rank[pa]++;
                parent[pb] = pa;
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU obj = new DSU(nums[nums.length - 1] + 1);
        for(int i =0;i<n-1;i++){
            if(Math.abs(nums[i] - nums[i+1]) <= maxDiff){
                obj.union(nums[i], nums[i+1]);
            }
        }

        boolean res[] = new boolean[queries.length];
        int idx =0;
        for(int num[] : queries){
            if(obj.find(nums[num[0]]) == obj.find(nums[num[1]])){
                res[idx] = true;
            }
            idx++;
        }

        return res;

    }
}