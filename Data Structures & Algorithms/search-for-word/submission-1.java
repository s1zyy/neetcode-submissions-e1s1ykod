class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board[0].length; k++){
                if(board[i][k] == word.charAt(0)){
                    if(check(board,word,i,k,0)) return true;
                    
                }
            }
        }
        return false;
        }

    public boolean check(
        char[][] board,
        String word,
        int row,
        int col,
        int index
          ) {
        if(row < 0 
         || col < 0
         || row >= board.length
         || col >= board[0].length
         ||board[row][col] != word.charAt(index)
         ) {
            return false;
        } else if(index == word.length()-1){
            return true;
        }
        char temp = board[row][col];
        board[row][col] = '@';
        boolean found = 
            check(board, word, row, col+1, index+1) ||
            check(board, word, row, col-1, index+1) ||
            check(board, word, row+1, col, index+1) ||
            check(board, word, row-1, col, index+1);
        board[row][col] = temp;
        return found;

        
    }
}
