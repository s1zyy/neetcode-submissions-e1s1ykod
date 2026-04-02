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
                System.out.println("Right" + r);
                System.out.println("Distance" + distance);
                currentVolume = r * distance;
            } else {
                currentVolume = l * distance;
            }
            if(maxVolume < currentVolume) {
                //System.out.println(currentVolume);
             
                maxVolume = currentVolume;
                //System.out.println(maxVolume);
            }

            if(l > r) {
                //System.out.println("Right move <- " + r);
                right--;
            } else {
                //System.out.println("Left move -> " + l);
                left++;
            }
        }
        

        return maxVolume;
    }
}
