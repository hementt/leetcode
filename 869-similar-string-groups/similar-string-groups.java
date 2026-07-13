class Solution {
    class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a,int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return;

            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }
            else if(rank[pb] < rank[pa]){
                parent[pb] = pa;
            }
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU obj = new DSU(n);
        for(int i =0; i<n;i++){
            for(int j = i+1; j<n;j++){
                int similar = 0;
                int k = 0;
                String s1 = strs[i];
                String s2 = strs[j];
                while(k < s1.length()){
                    if(s1.charAt(k) == s2.charAt(k)) similar++;
                    k++;
                }
                if((s1.length() - similar) == 2 || (s1.length() - similar) == 0 ){
                    obj.union(i, j);
                }
            }
        }

        int comp = 0;
        for(int i =0; i<n;i++){
            if(obj.find(i) == i){
                comp++;
            }
        }
        return comp;
    }
}