class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0; 

        int[] result = new int[nums.length-k+1];

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]
        );
        

        for(int right = 0; right < nums.length; right++) {

            queue.add(new int[] {nums[right], right});

            if(right >= k-1) {
                while(queue.peek()[1] < left ) {
                    queue.poll();
                }
            
                result[left] = queue.peek()[0];

                left++;

            }
            
        }

        return result;
    }
}
