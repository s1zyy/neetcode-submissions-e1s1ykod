class Solution {
    public int maxSubArray(int[] nums) {
        int current = 0; 
        int largest = Integer.MIN_VALUE;

        for(int num : nums) {
            current += num;
            largest = Math.max(largest, current);
            if(current < 0) {
                current = 0;
            }
            
        }
        return largest;

        
    }
}
