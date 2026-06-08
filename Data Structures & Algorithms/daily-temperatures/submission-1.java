class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] array = new int[len];
        Stack<Integer> stack = new Stack<>();
        
      

        
        for(int i = 0; i < len; i++){
            while(!stack.empty()){
                if(temperatures[stack.peek()] < temperatures[i]){
                    int index = stack.pop();
                    array[index] = i - index;
                } else{
                    break;
                }
            }
            stack.push(i);
        }
        return array;
    }
}
