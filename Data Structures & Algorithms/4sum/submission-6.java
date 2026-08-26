class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            if(i>0){
                if(nums[i] == nums[i-1]) continue;
            }
            int num1 = nums[i];
            for(int k = i+1; k<l; k++) {
                if(k > i+1) if(nums[k] == nums[k-1]) continue;
                int num2 = nums[k];
                int left = k+1;
                int right = l-1;
                while(left < right) {
                    long sum = (long) num1 + num2 + nums[left] + nums[right];
                    if(sum == (long) target){
                        result.add(Arrays.asList(num1, num2, nums[left], nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]) left++;
                    while(left<right && nums[right] == nums[right+1]) right--;
                    } else if(sum > target){
                        right--;
                    } else if(sum < target) {
                        left++;
                    }
                }
            }
            
        }
        return result;

        
    }
}