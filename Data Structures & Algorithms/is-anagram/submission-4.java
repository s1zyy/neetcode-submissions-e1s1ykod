class Solution {
    public boolean isAnagram(String s, String t) {
        Map<String, Integer> map = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }


        for(int k = 0; k < s.length(); k++){
            map.put(s.charAt(k)+"", map.getOrDefault(s.charAt(k)+"", 0) +1);
            map.put(t.charAt(k)+"", map.getOrDefault(t.charAt(k)+"", 0) -1);

        }
        for(int num : map.values()){
            if(num != 0){
                return false;
            }
            
        }
        return true;
        

        
    }
}
