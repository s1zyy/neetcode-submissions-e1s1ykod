class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] l1 = new int[26];
        int[] l2 = new int[26];

        int left = 0;

        int length1 = s1.length();
        

        for(int k = 0; k < s1.length(); k++) {
            l1[s1.charAt(k) - 'a']++;
        }

        for(int right = 0; right < s2.length(); right++) {
        
            l2[s2.charAt(right) - 'a']++;
            if(right - left +1 > length1) {
                l2[s2.charAt(left) - 'a']--;
                left++;
            }

            if(Arrays.equals(l1,l2)) {
                return true;
            }
        }
        return false;
    }
}
