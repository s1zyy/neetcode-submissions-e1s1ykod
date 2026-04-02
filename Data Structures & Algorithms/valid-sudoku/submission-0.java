class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] column = new HashSet[9];
        HashSet<Character>[] square = new HashSet[9];


        for(int i = 0 ; i < 9; i++){
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++){
            
            for(int k = 0; k < 9; k++){
                char value = board[i][k];
                if(value == '.') {
                    continue;
                }

                int squareNum = (i/3)*3 + (k/3); //(2,2)0   (2,5)1, (5,5)

                if(row[i].contains(value) || column[k].contains(value) || square[squareNum].contains(value)){
                    return false;
                }
                row[i].add(value);
                column[k].add(value);
                square[squareNum].add(value);
            }
        }
        return true;

    }
}
