class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for(char c : s.toCharArray()) {
            mapA.merge(c, 1, (oldVal, newVal) -> oldVal + newVal);
        }
        for(char c : t.toCharArray()) {
            mapB.merge(c, 1, Integer::sum);
        }
        return mapA.equals(mapB);
    }
}
