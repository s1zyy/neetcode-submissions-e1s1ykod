class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        s = s.replaceAll("[^a-z0-9]", "");






        
        while(s.length() > 1) {
            if(s.charAt(0) != s.charAt(s.length() -1)){
                return false;
            } else {
                s = s.substring(1, s.length()-1);

            }
        }
        return true;
    }
}
