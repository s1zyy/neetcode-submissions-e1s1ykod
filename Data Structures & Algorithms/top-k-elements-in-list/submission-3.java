class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) -> {
                return map.get(b) - map.get(a);
            }
        );
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int num : map.keySet()) {
            queue.add(num);
        }
        int[] result = new int[k];
        for(int i =0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;


        
    }
}
