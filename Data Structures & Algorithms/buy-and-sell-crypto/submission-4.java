class Solution {
    public int maxProfit(int[] prices) {
        int leftMin = Integer.MAX_VALUE;
        int right = 0;
        int rightMax = 0;
        int maxProfit = 0;
        while(right < prices.length) {
            int r = prices[right];

            if(r < leftMin) {
                if(rightMax!=0){
                    maxProfit = rightMax - leftMin;
                }
                leftMin = r;
                rightMax = 0;
                right++;
                continue;
            }
            if(rightMax < r) {
                rightMax = r;
            }
            right++;
        }
        if(maxProfit < (rightMax-leftMin)){
            maxProfit = rightMax-leftMin;
        }
        return maxProfit;   
    }
}
