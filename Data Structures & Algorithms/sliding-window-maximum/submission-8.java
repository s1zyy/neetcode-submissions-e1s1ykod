class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0; 
        int right = k-1;

        int[] result = new int[nums.length-k+1];

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]
        );
        for(int i = 0; i < k-1; i++) {
            queue.add(new int[] {nums[i], i});
        }

        while(right < nums.length) {

            queue.add(new int[] {nums[right], right});
            
            while(queue.peek()[1] < left ) {
                queue.poll();
            }
            
            result[left] = queue.peek()[0];

            left++;
            right++;
        }

        return result;
    }
}
