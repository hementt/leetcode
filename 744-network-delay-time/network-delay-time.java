class Solution {
    class Pair{
        int node;
        int weight;

        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++) adj.add(new ArrayList<>());

        for(int num[] : times){
            adj.get(num[0]).add(new Pair(num[1], num[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Pair(k , 0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;

            for(Pair neigh: adj.get(node)){

                if(dist[neigh.node] > wt+neigh.weight){
                    dist[neigh.node] = wt+neigh.weight;
                    pq.add(new Pair(neigh.node, wt+neigh.weight));
                }
            }
        }

        int max = 0;
        for(int i =1;i<= n;i++){
            max = Math.max(max, dist[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;

    }
}