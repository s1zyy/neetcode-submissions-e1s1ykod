class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int counter = 0;
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
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
