class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        boolean[] visited = new boolean[n + 1];
        int maxTime = 0;
        int nodesVisited = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int u = curr[1];

            if (visited[u]) continue;
            
            visited[u] = true;
            maxTime = currTime; 
            nodesVisited++;

            if (graph.containsKey(u)) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int timeToV = edge[1];
                    if (!visited[v]) {
                        pq.offer(new int[]{currTime + timeToV, v});
                    }
                }
            }
        }
        return nodesVisited == n ? maxTime : -1;
    }
    
}