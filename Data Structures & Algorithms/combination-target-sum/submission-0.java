class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        int index = 0;
        int sum = 0;
        answer(nums, target, 0, comb, result);
        return result;
        
    }

    public void answer(
        int[] nums,
        int remaining,
        int start,
        List<Integer> comb,
        List<List<Integer>> result
        ) {
            if(remaining == 0 ) {
                result.add(new ArrayList<>(comb));
            } else if( remaining < 0 ) {
                return;
            }

            for(int i = start; i < nums.length; i++) {
                comb.add(nums[i]);
                answer(nums, remaining - nums[i], i, comb, result);
                comb.remove(comb.size()-1);
            }


    }
}
