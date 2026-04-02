class PrefixTree {

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }


    private TrieNode root;



    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c-'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];

        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                return false;
            } else {
                current = current.children[index];
            }
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null) {
                return false;
            } else {
                current = current.children[index];
            }
        }
        return true;
    }
}
