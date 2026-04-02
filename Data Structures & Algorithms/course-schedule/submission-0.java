class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i< prerequisites.length; i++) {
            if(map.containsKey(prerequisites[i][0])) {
                List<Integer> list = map.get(prerequisites[i][0]);
                list.add(prerequisites[i][1]);
            } else {
                map.computeIfAbsent(prerequisites[i][0],k -> new ArrayList<>()).add(prerequisites[i][1]);
            }
        }
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(i, map, visited)) {
                return false;
            }
        }
        return true;


        
    }

    public boolean hasCycle(int course, HashMap<Integer, List<Integer>> map, int[] visited) {
        if(visited[course] == 1) {
            return true;
        } 
        if(visited[course] == 2) {
            return false;
        }

        visited[course] = 1;

        if(map.containsKey(course)) {
            for(int nextCourse : map.get(course)) {
                if(hasCycle(nextCourse, map, visited)) {
                    return true;
                }
            }
        }
        visited[course] = 2;
        return false;
    }
}
