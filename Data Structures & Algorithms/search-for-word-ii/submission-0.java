class Solution 
{
    private class TrieNode 
    {
        TrieNode[] children = new TrieNode[26];
        String word = null; 
    }

    private int ROWS, COLS;
    // Tracks our coordinates path utilizing an optimized combined String key ("r,c") 
    // to bypass Java's slow Pair object instantiation allocation overhead
    private Set<String> path = new HashSet<>();
    // Tracks unique found words to avoid adding duplicate paths to the final result list
    private Set<String> resultWords = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) 
    {
        // 1. Build the Trie directory framework out of the input words list
        TrieNode root = new TrieNode();
        for (String w : words) 
        {
            TrieNode curr = root;
            for (char ch : w.toCharArray()) 
            {
                int index = ch - 'a';
                if (curr.children[index] == null) 
                {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = w; // Seal the leaf node marker with its true string value
        }

        ROWS = board.length;
        COLS = board[0].length;

        // 2. Scan every cell on the board as a potential starting anchor position
        for (int r = 0; r < ROWS; r++) 
        {
            for (int c = 0; c < COLS; c++) 
            {
                dfs(board, r, c, root);
            }
        }
        
        return new ArrayList<>(resultWords);
    }

    // Upgraded DFS parameter list: replaces 'word' string and index 'i' with the moving TrieNode pointer
    private void dfs(char[][] board, int r, int c, TrieNode node) 
    {
        // Out-of-bounds boundary guards or path tracking collision filter loops
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            path.contains(r + "," + c)) 
        {
            return;
        }

        char ch = board[r][c];
        TrieNode childNode = node.children[ch - 'a'];
        
        // If the current character path does not exist inside our words directory tree, cut this branch early!
        if (childNode == null) {
            return;
        }

        // Base Case Check: If this node marks the end of a word string, we found it!
        if (childNode.word != null) {
            resultWords.add(childNode.word);
            // Optimization: Set to null so we don't wastefully re-discover the same word via alternate paths
            childNode.word = null; 
        }

        // Choose: Mark current coordinates in our path tracker
        path.add(r + "," + c);
        
        // Explore: Traverse in all four grid direction vectors simultaneously down the Trie framework lines
        dfs(board, r + 1, c, childNode);
        dfs(board, r - 1, c, childNode);
        dfs(board, r, c + 1, childNode);
        dfs(board, r, c - 1, childNode);
        
        // Unchoose: Backtrack clean removal step to restore state tracking boards for adjacent loops
        path.remove(r + "," + c);
    }
}