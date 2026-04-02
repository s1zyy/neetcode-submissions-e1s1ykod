class Solution {
    public int maxProfit(int[] prices) {
        int leftMin = Integer.MAX_VALUE;
        
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            int num = prices[i];

            if(num < leftMin) {
                leftMin = num;
            } else {
                if(maxProfit < (num-leftMin)){
                    maxProfit = num-leftMin;
                }
            }
        }
        return maxProfit;
         
    }
}
