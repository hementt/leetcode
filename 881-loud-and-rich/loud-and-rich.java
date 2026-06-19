class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<quiet.length;i++) adj.add(new ArrayList<>());

        for(int i =0; i<richer.length;i++){
            adj.get(richer[i][0]).add(richer[i][1]);
        }

        int ans []= new int[quiet.length];
        for(int i =0; i<quiet.length;i++) ans[i] = i;

        int indegree[] = new int[quiet.length];

        for(int i =0;i<adj.size();i++){
            for(int j = 0; j<adj.get(i).size(); j++){
                indegree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i =0; i<quiet.length;i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh : adj.get(curr)){

                if(quiet[ans[curr]] < quiet[ans[neigh]]){
                    ans[neigh] = ans[curr];
                }

                if(--indegree[neigh] == 0) q.add(neigh);
            }
        }
        return ans;
    }
}