class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        
        int[] visited = new int[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                counter++;
                dfs(i, visited, map);
            }
        }

        return counter;
    }

    public void dfs(int node, int[] visited,
        HashMap<Integer, List<Integer>> map) {
        if(visited[node] != 0) {
            return;
        }

        visited[node] = 1;
        if(map.containsKey(node)) {
            for(int nextNode : map.get(node)) {
                dfs(nextNode, visited, map);
            }
        }

        visited[node] = 1;
        
    }
}
