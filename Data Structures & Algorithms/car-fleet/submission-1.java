class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int len = position.length;
        int[][] cars = new int[len][2];
        for(int i = 0; i < len; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b[0],a[0]));
        double[] time = new double[len];
        for(int i = 0; i < len; i++) {
            time[i] = (double)(target-cars[i][0]) / cars[i][1];
        }

        for(int i = 0; i < len; i++) {
            if(stack.isEmpty() || stack.peek() < time[i]){
                stack.push(time[i]);
            }
        }
        return stack.size();


        

        
    }
}
