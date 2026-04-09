class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
     
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(current.children[ch-'a'] == null) {
                current.children[ch-'a'] = new TrieNode();
            }
            current = current.children[ch-'a'];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        return isPresent(word, 0, current);
        
    }

    public boolean isPresent(String word, int index, TrieNode root) {
        if(index == word.length()) {
            return root.isEndOfWord;
        }
        
        char ch = word.charAt(index);
        if(ch == '.'){
            for(int i = 0; i < 26; i++) {
                if(root.children[i] != null) {
                    if(isPresent(word, index + 1, root.children[i])){
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(root.children[ch-'a'] == null) {
                return false;
            }
            return isPresent(word, index+ 1, root.children[ch-'a']);
        }
      





    }
}
