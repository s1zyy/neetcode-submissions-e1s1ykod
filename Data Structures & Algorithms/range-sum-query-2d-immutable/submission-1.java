class NumMatrix {

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        sumMatrix[0][0] = matrix[0][0];
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 1; i < row; i++) {
            sumMatrix[i][0] = sumMatrix[i-1][0] + matrix[i][0];
        }
        for(int i = 1; i < col; i++) {
            sumMatrix[0][i] = sumMatrix[0][i-1] + matrix[0][i];
        }

        for(int i = 1; i < row; i++) {
            for(int k = 1; k < col; k++) {
                sumMatrix[i][k] = sumMatrix[i-1][k] + sumMatrix[i][k-1] - sumMatrix[i-1][k-1] + matrix[i][k];
            }
        }

        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row2][col2];
        if(row1 > 0){
            sum -= sumMatrix[row1-1][col2];
        }
        if(col1 > 0) {
            sum -= sumMatrix[row2][col1-1];
        }
        if(row1 > 0 && col1 > 0) {
            sum += sumMatrix[row1-1][col1-1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */