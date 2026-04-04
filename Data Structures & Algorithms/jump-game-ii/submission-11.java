class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int currentEnd = 0;

        int jumps = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length-1; i++) {
            
            farthest = Math.max(farthest, nums[i] + i);

            if(i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
            
        
        }
        
        return jumps;
    }
} 
