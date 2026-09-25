class Solution {


    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int k = 0; k < grid[0].length; k++) {
                if(grid[i][k] == '1') {
                    counter++;
                    dfs(i,k,grid);
                }
            }
        }
        return counter;



        
    }

    public void dfs(int row, int col, char[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == '0') return;
        if(grid[row][col] == '*') return;

        grid[row][col] = '*';
            
        dfs(row+1,col,grid);
        dfs(row,col+1,grid);
        dfs(row-1,col,grid);
        dfs(row,col-1,grid);


         
    }
}
