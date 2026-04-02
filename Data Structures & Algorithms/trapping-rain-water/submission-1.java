class Solution {
    public int trap(int[] height) {
        int finalVolume = 0;

        int left = 1;
        int right = height.length-2;
        int leftMax = height[0];
        int rightMax = height[height.length-1];

        while(left <= right) { 
            /*

            if height[left] < height[right] think
            work with leftmax - i.height
            else rightmax - i.height

            
            */
            if(height[left] > leftMax) {
                leftMax = height[left];
                left++;
                continue;
            }
            if(height[right] > rightMax) {
                rightMax = height[right];
                right--;
                continue;
            }

            if(leftMax > rightMax) {
                int sum = rightMax - height[right]; 
                System.out.println("L>R " +sum);
                if(sum==1){
                    System.out.println(left + " + " + right);
                }
                finalVolume += sum;
                right--;
            } else {
                int sum = leftMax - height[left];
                System.out.println("R>L "+ sum);

                finalVolume += sum;
                left++;
            }
           
        }
        return finalVolume;
    }
}
