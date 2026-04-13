class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] pacificReach = new boolean[r][c];
        boolean[][] atlanticReach = new boolean[r][c];

        for(int i = 0; i < heights.length; i++) {
            canReach(heights,i,0,pacificReach, 0);
            canReach(heights,i, heights[0].length-1,atlanticReach, 0);
        }
        for(int i = 0; i < heights[0].length; i++) {
            canReach(heights,0,i,pacificReach, 0);
            canReach(heights,heights.length-1, i ,atlanticReach, 0);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++){
                if(pacificReach[i][j] && atlanticReach[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;


    }

    public void canReach(int[][] heights, int row, int col,
        boolean[][] reach, int prev) {
            if(row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) {
                return;
            }

            if(reach[row][col]) {
                return; 
            }

            int cur = heights[row][col];

            if(cur < prev) {
                return;
            }
            reach[row][col] = true;

            canReach(heights, row+1, col, reach, cur);
            canReach(heights, row, col+1, reach, cur);
            canReach(heights, row-1, col, reach, cur);
            canReach(heights, row, col-1, reach, cur);


        }
}
