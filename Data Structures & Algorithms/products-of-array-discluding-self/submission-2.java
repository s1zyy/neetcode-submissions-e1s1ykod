class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length-1] = 1;
        for(int i = 1; i < length; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        for(int k = length-2; k >= 0; k--){
            right[k] = right[k+1] * nums[k+1];
            System.out.println(right[k]);
        }
        for(int l = 0; l < length; l++){
            nums[l] = left[l] * right[l];
        }
        return nums;
    }
}  
