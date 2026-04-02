class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return mySearch(word, node, 0);

    }

    public boolean mySearch(String word, TrieNode node, int index) {
        if(index >= word.length()) {
            return node.isEndOfWord;
        }
        char ch = word.charAt(index);
        if(ch != '.'){
            int ind = ch - 'a';
            if(node.children[ind] == null) {
                return false;
            } else {
                node = node.children[ind];
                return mySearch(word, node, index+1);
            }
        } else {
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null) {
                    if (mySearch(word,node.children[i],index+1)) {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
}
