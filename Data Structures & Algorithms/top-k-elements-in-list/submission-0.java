class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        Hash map to count numbers?
        and then put in priority queue which will sort them by the 
        hash value
        */

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) -> map.get(a) - map.get(b)
        );

        for(int key : map.keySet()){
            queue.add(key);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];

        for(int i = k-1; i >=0; i--){
            result[i] = queue.poll();
        }

        
        return result;


    }
}
