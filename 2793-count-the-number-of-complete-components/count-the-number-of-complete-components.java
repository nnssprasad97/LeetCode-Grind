class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Find components using DFS
        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                components.add(component);
            }
        }
        
        // Count complete components
        int completeCount = 0;
        for (List<Integer> component : components) {
            int size = component.size();
            int requiredEdges = size * (size - 1) / 2;  // edges in complete graph
            int actualEdges = 0;
            
            // Count edges in this component
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int v1 = component.get(i);
                    int v2 = component.get(j);
                    if (adj.get(v1).contains(v2)) {
                        actualEdges++;
                    }
                }
            }
            
            if (actualEdges == requiredEdges) {
                completeCount++;
            }
        }
        
        return completeCount;
    }
    private void dfs(int vertex, List<List<Integer>> adj, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        
        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }
}