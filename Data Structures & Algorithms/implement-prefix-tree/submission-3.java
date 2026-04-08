class PrefixTree {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
     
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    


    public void insert(String word) {
        TrieNode non = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(non.children[index] == null) {
                non.children[index] = new TrieNode();
            }
            non = non.children[index];
        }
        non.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode non = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) -'a';
            if(non.children[index] == null) {
                return false;
            }
            non = non.children[index];
        }
        return non.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode non = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(non.children[index] == null) {
                return false;
            }
            non = non.children[index];
        }
        return true;

    }
}
