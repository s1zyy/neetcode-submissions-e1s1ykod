class Solution {
    public int largestRectangleArea(int[] heights) {
     
        Stack<Integer> stack = new Stack<>();
        if(heights.length==0) return 0;
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            if(heights[i] < heights[stack.peek()]){
                while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int index = stack.pop();
                int right = i;
                int left;
                if(stack.isEmpty()){
                    left = -1;
                } else left = stack.peek();
                int width = (right - left) - 1;
                maxArea = Math.max(maxArea,width * heights[index]);
                
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            int right = heights.length;
            int left = stack.isEmpty() ? -1 :stack.peek();
            int width = (right-left) -1;
            maxArea = Math.max(maxArea,width * heights[index]);
        }
        return maxArea;
    }
}
