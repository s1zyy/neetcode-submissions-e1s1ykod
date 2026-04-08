class Solution {
    public int characterReplacement(String s, int k) {
        int counter = 0;
        int left = 0;
        int maxLen = 0;
        int maxCount = 0;

        int[] counts = new int[26];

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            counts[ch-'A']++;
            maxCount = Math.max(maxCount, counts[ch-'A']);
            if((right-left+1 - maxCount) <= k) {
                maxLen = Math.max(maxLen, right-left+1);
            } else {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return maxLen;

    }
}
