class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> listOfList = new ArrayList<>();


        
        for(int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int currentValue = nums[i];
            int left = i+1;
            int right = nums.length-1;

            while(left < right) {
                int l = nums[left];
                int r = nums[right];
            
                if(l+r > -currentValue) {
                    right--;
                } else if(l+r < -currentValue) {
                    left++;
                } else {
                    listOfList.add(Arrays.asList(currentValue, l, r));
                    right--;
                    left++;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }

        return listOfList;
        
    }
}
