class Solution {
    public int maxArea(int[] heights) {
        int maxVolume = 0;
        int left = 0;
        int right = heights.length-1;
        while(left < right) {
            int currentVolume;
            int l = heights[left];
            int r = heights[right];
            int distance = right - left;
            if(l > r) {
                currentVolume = r * distance;
            } else {
                currentVolume = l * distance;
            }
            if(maxVolume < currentVolume) {
                maxVolume = currentVolume;
            }

            if(l > r) {
                right--;
            } else {
                left++;
            }
        }
        return maxVolume;
    }
}
