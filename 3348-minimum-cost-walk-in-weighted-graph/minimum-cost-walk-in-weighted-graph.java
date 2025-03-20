import java.util.*;

class Solution {
    private List<int[]>[] graph;
    private boolean[] visited;
    private int[] componentId; // To track which component each vertex belongs to
    private Map<Integer, Integer> componentCost; // Cost for each component
    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // Initialize graph
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        
        // Find connected components and their costs
        visited = new boolean[n];
        componentId = new int[n];
        Arrays.fill(componentId, -1);
        componentCost = new HashMap<>();
        
        int compId = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, component);
                
                // Calculate cost for this component
                Set<Integer> weights = new HashSet<>();
                for (int node : component) {
                    for (int[] neighbor : graph[node]) {
                        weights.add(neighbor[1]);
                    }
                }
                
                int cost = -1;
                for (int w : weights) {
                    cost &= w;
                }
                
                // Assign component ID and cost
                for (int node : component) {
                    componentId[node] = compId;
                    componentCost.put(compId, cost);
                }
                compId++;
            }
        }
        
        // Process queries
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0];
            int t = query[i][1];
            
            // If both vertices are in same component (same compId), return cost
            if (componentId[s] != -1 && componentId[s] == componentId[t]) {
                result[i] = componentCost.get(componentId[s]);
            } else {
                result[i] = -1;
            }
        }
        
        return result;
    }
    
    private void dfs(int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        
        for (int[] neighbor : graph[node]) {
            int nextNode = neighbor[0];
            if (!visited[nextNode]) {
                dfs(nextNode, component);
            }
        }
    }
}