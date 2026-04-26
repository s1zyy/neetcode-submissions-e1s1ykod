class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];


        for(int i = 1; i < nums.length; i++) {
            if(i > maxReach) {
                return false;
            }
            
            maxReach = Math.max(nums[i] + i, maxReach);
            
        }
        return true;
        
    }
}
