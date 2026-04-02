class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            set.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>(set); 
        
        Collections.sort(list);
        int output = 1;
        int maxLength = 0;
        boolean oneFail = false;
        for(int i = 1; i < list.size(); i++) {
            
            if(list.get(i) - list.get(i-1) != 1){
                if(maxLength < output) {
                    maxLength = output;
                }
                output = 1;
            } else {
                output++;
            }

            
        }
        if(output > maxLength) {
            maxLength = output;
        }
        
        return maxLength;
    }
}
