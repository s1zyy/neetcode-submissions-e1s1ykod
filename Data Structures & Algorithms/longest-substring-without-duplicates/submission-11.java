class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0; 
        int right = 0;
        int maxCounter = 0;
        

        while(right < s.length()){
            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            } // zxyzxyz
            maxCounter = Math.max(maxCounter, (right-left));

            while(right < s.length() && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxCounter;
        
    }
}
