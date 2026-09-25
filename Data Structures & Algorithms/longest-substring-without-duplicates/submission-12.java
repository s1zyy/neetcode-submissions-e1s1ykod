class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0; 
        int maxCounter = 0;
        

        for(int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxCounter = Math.max(maxCounter, (right-left + 1 ));

        }
        return maxCounter;
        
    }
}
