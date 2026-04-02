class Solution {
    public int maxProduct(int[] nums) {
        int[] maximum = new int[nums.length];
        int[] minimum = new int[nums.length];

        maximum[0] = nums[0];
        minimum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int tempMax = maximum[i-1];
            maximum[i] = Math.max(num, Math.max(num*maximum[i-1], num*minimum[i-1]));
            minimum[i] = Math.min(num, Math.min(num*maximum[i-1], num*minimum[i-1]));
        }
        int biggest = Integer.MIN_VALUE;
        for(int i : maximum) {
            biggest = Math.max(biggest, i);
        }
        return biggest;
        
    }
}
