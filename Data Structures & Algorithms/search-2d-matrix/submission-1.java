class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = (rows*cols)-1;
        while(left <= right) {
            int middle = (right + left) /2;
            int num = matrix[middle/ cols][middle%cols];
            if(num == target) return true;
            else if(num > target) {
                right = middle-1;
            } else if(num < target) {
                left = middle+1;
            }   
        }
        return false;
        
    }
}
