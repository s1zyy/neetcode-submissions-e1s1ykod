class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int biggest = Integer.MIN_VALUE;
        int currentSum = 0;

        

        for(int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            biggest = Math.max(biggest, currentSum);
            
            
        }

        return biggest;
    }
}
