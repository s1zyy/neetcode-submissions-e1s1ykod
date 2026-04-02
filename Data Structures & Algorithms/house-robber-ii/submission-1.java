class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        

        int noLast = simpleRob(nums, 0, nums.length-1);
        System.out.println(noLast);

        if(nums.length == 3) {
            return Math.max(noLast, Math.max(nums[1],nums[2]));
        }
        int noFirst = simpleRob(nums, 1, nums.length);
        System.out.println(noFirst);

     

        return Math.max(noLast, noFirst);
    }

    public int simpleRob(int[] nums, int start, int end) {
        // if(end-start == 1) {
        //     return nums[start];
        // }

        // if(end-start == 2) {
        //     return Math.max(nums[start], nums[start+1]);
        // }
        int prev1 = nums[start];
        int prev2 = Math.max(nums[start+1], nums[start]);

        for(int i = start+2; i < end; i++) {
            int temp = prev2;
            prev2 = Math.max(prev2, nums[i] + prev1);
            prev1 = temp;
        }

        return prev2;
    }
}
