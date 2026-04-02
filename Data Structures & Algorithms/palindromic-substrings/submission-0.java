class Solution {
    public int countSubstrings(String s) {
        int counter = 0;
        int lcounter = 0;
        for(int i = 0; i < s.length(); i++) {
            counter += expand(s, i, i, lcounter);
            counter += expand(s, i, i+1, lcounter);
            
        }
        return counter;
    }

    public int expand(String s, int left, int right, int counter) {
  
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            counter++;
            left--;
            right++;
        }
        return counter;   
    }
}
