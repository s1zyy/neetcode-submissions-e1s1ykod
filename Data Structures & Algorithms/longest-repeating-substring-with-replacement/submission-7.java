class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0;
        int maxLength = 0;

        int left = 0;

        int[] counts = new int[26];


        for(int right = 0; right< s.length(); right++) {
            int num = s.charAt(right) - 'A';
            counts[num] += 1;
            maxCount = Math.max(maxCount, counts[num]);

            int window = right - left - maxCount ;
            while((right-left+1) - maxCount > k) {
                counts[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            
        }
        

        return maxLength;
    }
}
