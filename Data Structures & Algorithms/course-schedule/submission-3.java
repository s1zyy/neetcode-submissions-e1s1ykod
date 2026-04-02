class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][0],
            k -> new ArrayList<>()).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(hasLoop(visited, i, map)){
                return false;
            }
        }

        return true;



    }

    public boolean hasLoop(int[] visited, int course, HashMap<Integer, List<Integer>> map) {
        if(visited[course] == 2) {
            return false;
        }
        
        if(visited[course] == 1) {
            return true;
        } 

        visited[course] = 1;

        if(map.containsKey(course)) {
            for(int nextCourse : map.get(course)) {
            
                if(hasLoop(visited, nextCourse, map)) {
                   return true;
                };
            }
        }
        
        visited[course] = 2;
        return false;
    }
}
