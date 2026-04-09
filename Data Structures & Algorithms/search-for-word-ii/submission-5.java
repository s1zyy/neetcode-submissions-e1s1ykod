class Solution {

    class TrieNode {
        TrieNode[] children;
        String word;

     
        public TrieNode() {
            children = new TrieNode[26];

            word = null;
        }
    }
    TrieNode root;

    public Solution() {
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
        current.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(int i = 0; i < words.length; i++) {
            addWord(words[i]);
        }

        List<String> result = new ArrayList<>();
        TrieNode current = root;
       

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                
                dfs(board, r, c, current, result);
                
                
            }
        }
    
        return result;

        


    }

    public void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '*') {
            return;
        }

        char letter = board[r][c];
        if(node.children[letter-'a'] == null){
            return;
        }
        

        TrieNode nextNode = node.children[letter-'a'];

        if(nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }


        
        board[r][c] = '*';
        
        dfs(board, r+1, c, nextNode, result);
        dfs(board, r, c+1, nextNode, result);
        dfs(board, r-1, c, nextNode, result);
        dfs(board, r, c-1, nextNode, result);

        board[r][c] = letter;

    }
}
