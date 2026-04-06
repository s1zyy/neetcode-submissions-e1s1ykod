class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while((top <= bottom) && (left <= right)) {

            //top 
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if(top>bottom) break;

            //right
            for(int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(left>right) break;

            //bottom
            for(int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom) break;

            //left
            for(int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;
        }
        return list;
    }
}
