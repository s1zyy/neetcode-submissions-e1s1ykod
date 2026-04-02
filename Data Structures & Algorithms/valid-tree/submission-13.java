class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) {
            return false;
        }
        // if( n == 1 ) {
        //     return true;
        // }
        

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] con : edges) {
            int u = con[0];
            int v = con[1];
            map.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
        }
        System.out.println(map);

        int[] visited = new int[n];

        
        if(hasLoop(0, -1, visited, map)) {
            return false;
        }
        

        for(int i : visited) {
            System.out.println(i);
            if(i == 0 ) {
                System.out.println("error visited");
                return false;
            }
        }
        return true;


    }

    public boolean hasLoop(int node, int parent,
            int[] visited,HashMap<Integer, List<Integer>> map) {
        if(visited[node] == 1 ) {
            return true;
        }
        if(visited[node] == 2) {
            return false;
        }

        visited[node] = 1;
        if(map.containsKey(node)) {
            for(int nextNode : map.get(node)) {
                if(nextNode != parent) {
                    if(hasLoop(nextNode, node, visited, map)) {
                        return true;
                    }
                }
            }
        }
        visited[node] = 2;
        return false;
    }
}
