class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0; 
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length){
            if(sum >= target){
                min = Math.min(min,right-left);
                sum -= nums[left];
                left++;
            } else {
                sum += nums[right];
                right++;
            }
        }
        while(left < nums.length) {
            if(sum >= target) {
                min = Math.min(min,right-left);
                sum -= nums[left];
                left++;
            } else {
                break;
            }
        }
        return min == Integer.MAX_VALUE ? 0: min;
        
    }
}