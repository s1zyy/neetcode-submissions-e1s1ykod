class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int left = 0; 
        int right = nums.length-1;


        for(int i = 0; i < nums.length-1; i++){
            if(i > 0) {
                if(nums[i] == nums[i-1]) {
                    continue;
                }
            }
            int num = nums[i];
            left = i+1;
            right = nums.length-1;

            while(left < right) {
                int l = nums[left];
                int r = nums[right];
                if(l + r == -num) {
                   
                    result.add(Arrays.asList(num, l, r));
                    left++;
                    right--;

                    while((left < right) && nums[left] == nums[left-1]){
                        left++;
                    }
                    while((left < right) && nums[right] == nums[right+1]){
                        right--;
                    }
                } else if(l+r > -num) {
                    right--;
                } else if(l+r < -num) {
                    left++;
                }
            }
        }
        return result;
    }
}
