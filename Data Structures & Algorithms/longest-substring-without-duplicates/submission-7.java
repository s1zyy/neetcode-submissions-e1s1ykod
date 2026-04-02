class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int maxLength = 1;
        int left = 0;
        int right = 1;
        set.add(s.charAt(0));
        for(int i = 0; i < s.length()-1; i++) {
            char r = s.charAt(right);
            
            while(set.contains(r)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(r);

            maxLength = Math.max(maxLength, right - left +1);
            right++;
        }
        return maxLength;
    }
}
