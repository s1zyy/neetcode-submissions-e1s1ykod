class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length()>s.length()) {
            return "";
        }
        
        int left = 0; 
        int right =0;
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
       

        int[] countT = new int[128];
        int[] window = new int[128];
        int need = 0;

        for(int i = 0; i < t.length(); i++) {
            countT[t.charAt(i)]++;
        }

        for(int i = 0; i < countT.length; i++) {
            if(countT[i] > 0) {
                need++;
            }
        }

        while(right < s.length()) {
            window[s.charAt(right)]++;
            if(window[s.charAt(right)] == countT[s.charAt(right)]) {
                have++;
            }
            while(have == need) {
                window[s.charAt(left)]--;
                if(window[s.charAt(left)] < countT[s.charAt(left)]){
                    System.out.println("Left :  " + left);
                    System.out.println("Len : " + minLen);
                    have--;
                    if(minLen > right-left+1) {
                        minLen = right-left+1;
                        startIndex = left;
                    }
                    
                   
                }
                left++;
                
            }
            right++;
        }

        if(minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIndex, startIndex + minLen);

        

    }
}
