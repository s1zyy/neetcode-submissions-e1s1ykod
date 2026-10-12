class Solution {
    public boolean isAnagram(String s, String t) {

            Map<Character, Integer> a = new HashMap<>(), b = new HashMap<>();
for (char c : s.toCharArray()) a.merge(c, 1, Integer::sum);
for (char c : t.toCharArray()) b.merge(c, 1, Integer::sum);
return a.equals(b);
    }
}
