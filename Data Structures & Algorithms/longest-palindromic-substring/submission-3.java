class Solution {
    public String longestPalindrome(String s) {
        String maxString = "";
        for(int i = 0; i < s.length(); i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i+1);

            if(odd.length() > maxString.length()) maxString = odd;
            if(even.length() > maxString.length()) maxString = even;
            
        }
        return maxString;
    }

    public String expand(String s, int left, int right) {
  
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);   
    }
}
