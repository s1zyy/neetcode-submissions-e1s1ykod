class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                counter++;
                dfs(i, visited, map);
            }
        }

        return counter;
    }

    public void dfs(int node, boolean[] visited,
        HashMap<Integer, List<Integer>> map) {
        if(visited[node]) {
            return;
        }

        visited[node] = true;
        if(map.containsKey(node)) {
            for(int nextNode : map.get(node)) {
                dfs(nextNode, visited, map);
            }
        }

        
    }
}
