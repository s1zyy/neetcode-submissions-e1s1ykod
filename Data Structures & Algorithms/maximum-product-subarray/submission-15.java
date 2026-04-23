class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = currentMax;
            currentMax = Math.max(num, Math.max(tempMax*num, currentMin*num));
            currentMin = Math.min(num, Math.min(tempMax*num, currentMin*num));
            globalMax = Math.max(globalMax,currentMax);
        }

        return globalMax;
    }
}
