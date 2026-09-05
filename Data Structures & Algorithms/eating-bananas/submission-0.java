class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for(int pile : piles) {
            right = Math.max(right, pile);
        }
        if(piles.length == h) {
            return right;
        }
        int left = 1;
        int answer = right;
        while (left <= right) {
            int middle = left + (right-left) / 2;

            long totalHours = 0;
            for(int pile : piles) {
                totalHours += (pile + middle -1) / middle;
            }
            if(totalHours > h ) left = middle +1;
            else if(totalHours <= h){
                right = middle -1;
                answer = Math.min(answer,middle);
            }
        }
        return answer;
        


        
    }
}
