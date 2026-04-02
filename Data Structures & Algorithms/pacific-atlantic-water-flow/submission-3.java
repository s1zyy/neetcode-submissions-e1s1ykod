class Solution {

   

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> answer = new ArrayList<>();
        boolean[][] pacificReach = new boolean[rows][cols];
        boolean[][] atlanticReach = new boolean[rows][cols];
        

        for(int row = 0; row < heights.length; row++) {
            check(heights,row,0,Integer.MIN_VALUE,pacificReach);
        }
        for(int col = 0; col < heights[0].length;col++) {
            check(heights,0,col,Integer.MIN_VALUE,pacificReach);
        }
        for(int row = 0; row < heights.length; row++) {
            check(heights,row,heights[0].length-1,Integer.MIN_VALUE,atlanticReach);
        }
        for(int col = 0; col < heights[0].length;col++) {
            check(heights,heights.length-1,col,Integer.MIN_VALUE,atlanticReach);
        }
        for(int r=0; r<heights.length;r++){
            for(int c = 0; c<heights[0].length;c++) {
                if(atlanticReach[r][c] && pacificReach[r][c]) {
                    answer.add(Arrays.asList(r,c));
                }
            }
        }
        return answer;
    }
    

    public void check(int[][] heights, int row, int col, int prev, boolean[][] reachable) {
        if(row<0||col<0||row>=heights.length||col>=heights[0].length) return;

        if(heights[row][col] < prev) return;

        if(reachable[row][col]) return;

        reachable[row][col] = true;

        check(heights,row-1,col,heights[row][col],reachable);
        check(heights,row+1,col,heights[row][col],reachable);
        check(heights,row,col-1,heights[row][col],reachable);
        check(heights,row,col+1,heights[row][col],reachable);
    }
}
