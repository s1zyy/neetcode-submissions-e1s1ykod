class Solution {
    public int maxSubArray(int[] nums) {
        int current = 0; 
        int largest = Integer.MIN_VALUE;

        for(int num : nums) {
            current = Math.max(num, current + num);
            largest = Math.max(largest, current);
        }
        return largest;

        
    }
}
