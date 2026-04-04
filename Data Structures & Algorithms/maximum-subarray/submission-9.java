class Solution {
    public int maxSubArray(int[] nums) {
        int biggest = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            biggest = Math.max(biggest, currentSum);
        }

        return biggest;
    }
}
