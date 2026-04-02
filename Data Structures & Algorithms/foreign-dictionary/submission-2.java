class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                map.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }
        for(int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length()> w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for(int j = 0; j < minLen; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        int[] visited = new int[30];
        StringBuilder builder = new StringBuilder();

        for(char ch: map.keySet()){
            if(visited[ch-'a'] == 0) {
                if(!dfs(ch, visited, map, builder)){
                    return "";
                }
            }
        }

        return builder.reverse().toString();


        
        

    }

    public boolean dfs(char letter, int[] visited,
        HashMap<Character, Set<Character>> map, StringBuilder builder) {
            if(visited[letter-'a'] == 1) {
                return false;
            }
            if(visited[letter-'a'] == 2) {
                return true;
            }

            visited[letter-'a'] = 1;

            if(map.containsKey(letter)) {
                for(char nextLetter : map.get(letter)) {
                    if(!dfs(nextLetter, visited, map, builder)){
                        return false;
                    }
                }
            }

            visited[letter-'a'] = 2;
            builder.append(letter);
            return true;
    }

    
}