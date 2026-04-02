class Solution {


    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }
    private TrieNode root;

    public Solution(){
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
        current.word = word;
    }


    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for(int p = 0; p < words.length; p++) {
            insert(words[p]);
        }
        List<String> result = new ArrayList<>();
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                dfs(board, r,c,root,result);
            }
        }
        return result;

    }

    public void dfs(char[][] board, int r,int c, TrieNode node, List<String> result) {
        if(r < 0 ||
            c < 0 ||
            r >= board.length||
            c >= board[0].length||
            board[r][c] == '@' ) return;
            char ch = board[r][c];

        if(node.children[ch - 'a'] == null) {
            return;
        }
        TrieNode nextNode = node.children[ch - 'a'];

        if(nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }

        
        board[r][c] = '@';

        dfs(board, r+1, c, nextNode, result);
        dfs(board, r-1, c, nextNode, result);
        dfs(board, r, c+1, nextNode, result);
        dfs(board, r, c-1, nextNode, result);

        board[r][c] = ch;
        

    }
}
