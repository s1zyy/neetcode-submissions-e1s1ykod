class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length + 1 ];
        int[] dpMin = new int[nums.length + 1 ];

        int currentMax = nums[0];
        int currentMin = nums[0];

        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tempMax = currentMax;

            currentMax = Math.max(n, Math.max(tempMax * n , currentMin * n));
            currentMin = Math.min(n, Math.min(tempMax * n , currentMin * n));
            result = Math.max(result, currentMax);
        }
        return result;
    }
}
