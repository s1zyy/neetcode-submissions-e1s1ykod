class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0; 
        int right = -1;

        int[] result = new int[nums.length-k+1];

        PriorityQueue<Integer> queue = new PriorityQueue<>(
            Comparator.reverseOrder()
        );

        while(right < nums.length) {


            if(queue.size() < k) { 
                right++;
                queue.add(nums[right]);
                continue; 
            }
            


            result[left] = queue.peek();
            queue.remove(nums[left]);
            left++;

            right++;
            if(right < nums.length){
                queue.add(nums[right]);
            }

        }

        return result;
    }
}
