class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<>();

        int[] visited = new int[26];
        StringBuilder builder = new StringBuilder();

        for(String word: words) {
            for(int i = 0; i < word.length(); i++) {
                map.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }

        for(int i = 0 ; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                    return "";
                }

            int minLen = Math.min(word1.length(), word2.length());

            for(int j = 0; j < minLen; j++){
                char l1 = word1.charAt(j);
                char l2 = word2.charAt(j);
                if(l1 == l2){
                    continue;
                }
                map.get(l1).add(l2);
                break;
            }
        }

        for(char ch : map.keySet()){
            if(!dfs(ch, visited, map, builder)){
                return "";
            }
        }
        return builder.reverse().toString();



      
    }

    public boolean dfs(char letter, int[] visited,
        HashMap<Character, Set<Character>> map, StringBuilder builder) {
            switch(visited[letter-'a']){
                case 1:
                    return false;
                case 2:
                    return true;
            }

            visited[letter-'a'] = 1;

            for(char ch : map.get(letter)){
                if(!dfs(ch, visited, map, builder)){
                    return false;
                }
            }

            visited[letter-'a'] = 2;

            builder.append(letter);
            return true;

            /*
            check if we already visited current letter
            check if map contains current letter
            do dfs for the next letter, why?
            why do we put letters into our map.
            if letter is ok update visited and add letter to builder, return true
            */
        
        }
}
