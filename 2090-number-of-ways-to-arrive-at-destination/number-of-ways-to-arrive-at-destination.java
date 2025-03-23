class Solution {
    public int countPaths(int n, int[][] roads) {
        // Create adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Initialize distances and ways arrays
        long MOD = 1_000_000_007;
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        
        // Priority queue to store [node, distance]
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});  // [node, distance]
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[1];
            int u = (int)curr[0];
            
            // If we found a longer path, skip
            if (d > dist[u]) continue;
            
            // Explore neighbors
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                long time = neighbor[1];
                
                // If we find a shorter path
                if (d + time < dist[v]) {
                    dist[v] = d + time;
                    ways[v] = ways[u];
                    pq.offer(new long[]{v, dist[v]});
                }
                // If we find another path with same shortest distance
                else if (d + time == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        
        return (int)ways[n-1];
    }
}