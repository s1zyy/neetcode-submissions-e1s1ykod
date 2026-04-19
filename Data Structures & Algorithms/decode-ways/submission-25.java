class Solution {
    public int numDecodings(String s) {
        //through dp. remember what was the previous result.
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        
        int[] dp = new int[s.length()+1];
        dp[0] = 1; 
        dp[1] = 1;

        // we take how many ways we had at i-1(if we take 1 number) and at 
        // i-2 (if we take 2 numbers) and dp[i] = sum of i-1 and i-2.

        for(int i = 2; i <= s.length(); i++) {
            int oneDigit = 0;
            int twoDigit = 0;

            if(s.charAt(i-1) != '0' ){
                oneDigit = dp[i-1];
            }
            System.out.println(oneDigit);
            int num = Integer.parseInt(s.substring(i-2,i));

            if(num >= 10 && num <= 26) {
                twoDigit = dp[i-2];
            }
            System.out.println(twoDigit);

            dp[i] = oneDigit + twoDigit;
            
            
        }
        return dp[s.length()];
        
    }

   
}
