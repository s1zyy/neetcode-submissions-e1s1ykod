class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replace(" ", "");
        System.out.println(s);
        int left = 0; int right = s.length()-1;
        char[] arr = s.toCharArray();

        while (left < right) {
            if(!Character.isLetterOrDigit(arr[left])) left++;
            else if(!Character.isLetterOrDigit(arr[right])) right --;
            else {
                if(arr[left] != arr[right]) return false;
                left++;
                right--;
        }
        }
        return true;
        
    }
}
