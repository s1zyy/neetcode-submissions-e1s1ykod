class Solution {
    public int missingNumber(int[] nums) {
        int counter = 0;
        Arrays.sort(nums);
        for(int i = 1; i <= nums.length; i++){
            if((i ^ nums[i-1]) != 0) {
                counter++;
            }
        }
        return counter;
        
    }
}
