class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int[] visited = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][0],
            k -> new ArrayList<>()).add(prerequisites[i][1]);
        }

        for(int i = 0; i < prerequisites.length; i++) {
            if(hasLoop(visited, prerequisites[i][0], map)){
                return false;
            }
        }
        return true;

        
        
    }

    public boolean hasLoop(int[] visited, int course,
        HashMap<Integer, List<Integer>> map) {


            switch(visited[course]){
                case 1: 
                    return true;
                    
                case 2: 
                    return false;
                   

            }
            


            visited[course] = 1;



            if(map.get(course) != null) {
                for(int required: map.get(course)) {
                    if(hasLoop(visited, required, map)){
                        return true;
                    }
                }
            }
           

            visited[course] = 2;

            return false;
            
    }
}
