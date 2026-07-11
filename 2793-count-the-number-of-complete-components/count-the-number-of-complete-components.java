class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n;i++) adj.add(new ArrayList<>());
        for(int num[] : edges){
            int u = num[0];
            int v = num[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean isVis[] = new boolean[n];
        int res = 0;

        for(int i =0; i<n;i++){
            if(!isVis[i]){
                isVis[i] = true;
                Queue<Integer> q = new LinkedList<>();
                List<Integer> list = new ArrayList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int node = q.poll();
                    list.add(node);

                    for(int neigh: adj.get(node)){
                        
                        if(!isVis[neigh]){
                            isVis[neigh] = true;
                            q.add(neigh);
                        }
                    }
                }
                int v = list.size();
                int target = v * (v - 1);
                int currTarget = 0;
                for(int num : list) currTarget += adj.get(num).size();
                if(target == currTarget) res++;
            }
            

        }
        return res;

    }
}