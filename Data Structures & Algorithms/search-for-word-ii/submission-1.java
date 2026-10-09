class Solution 
{
    private int ROWS, COLS;
    private Set<Pair<Integer, Integer>> path = new HashSet<>();
    
    // CHANGE 1: Signature updated to accept the string array and return a list of matches
    public List<String> findWords(char[][] board, String[] words) 
    {
        // Use a set to automatically filter out duplicate word matches
        Set<String> matchedResult = new HashSet<>();
        
        ROWS = board.length;
        COLS = board[0].length;

        // CHANGE 2: Wrap your original grid search inside an outer loop testing each word
        for (String word : words) 
        {
            if (matchedResult.contains(word)) continue;
            
            // This flag lets us break early out of the loops once the word is found
            boolean found = false; 
            path.clear(); // Clear the path tracking workspace before a new word search

            for (int r = 0; r < ROWS; r++) 
            {
                for (int c = 0; c < COLS; c++) 
                {
                    if (dfs(board, word, r, c, 0)) 
                    {
                        matchedResult.add(word);
                        found = true;
                        break; // Stop scanning rows for this specific word
                    }
                }
                if (found) break; // Stop scanning columns for this specific word
            }
        }
        
        return new ArrayList<>(matchedResult);
    }

    // Your exact, completely untouched Word Search I DFS logic engine
    private boolean dfs(char[][] board, String word, int r, int c, int i) 
    {
        if (i == word.length()) 
        {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            board[r][c] != word.charAt(i) ||
            path.contains(new Pair<>(r, c))) 
        {
            return false;
        }

        path.add(new Pair<>(r, c));
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      dfs(board, word, r - 1, c, i + 1) ||
                      dfs(board, word, r, c + 1, i + 1) ||
                      dfs(board, word, r, c - 1, i + 1);
        path.remove(new Pair<>(r, c));

        return res;
    }
}