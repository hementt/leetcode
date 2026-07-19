class Solution {

    class Pair {
        int node;
        long cost;

        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    class Pairs {
        int node;
        long cost;
        int d;

        Pairs(int node, int d, long cost) {
            this.node = node;
            this.d = d;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.get(u).add(new Pair(v, cost));
        }

        PriorityQueue<Pairs> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.d != b.d) {
                    return a.d - b.d;
                }
                return Long.compare(a.cost, b.cost);
            }
        );

        long[] dis = new long[n];

        Arrays.fill(dis, Long.MAX_VALUE);
        dis[src] = 0;

        int ans = Integer.MAX_VALUE;
        pq.offer(new Pairs(src, 0, 0));
        while (!pq.isEmpty()) {
            Pairs curr = pq.poll();

            int u = curr.node;
            int d = curr.d;
            long dist = curr.cost;

            if (u == dst && d-1  <= k) {
                ans = Math.min((int) dist, ans);
            }

            if (d  > k) {
                continue;
            }

            for (Pair p : adj.get(u)) {

                int v = p.node;
                int nd = d + 1;
                long ndis = p.cost;

                if (dist + ndis < dis[v]) {
                    dis[v] = dist + ndis;
                    pq.offer(new Pairs(v, nd, dis[v]));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}