class Solution {
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) 
    {
        ans = new ArrayList<>();
        queens(new boolean[n][n], 0);
        return ans;

    }

    int queens(boolean[][] board, int row) 
    {
        if (row == board.length) 
        {
            
            ans.add(constructBoardLayout(board));
            return 1;
        }

        int count = 0;

        // placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) 
        {
            // place the queen if it is safe
            if(isSafe(board, row, col)) 
            {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) 
    {
        // check vertical row
        for (int i = 0; i < row; i++) 
        {
            if (board[i][col]) 
            {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) 
        {
            if(board[row-i][col-i]) 
            {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) 
        {
            if(board[row-i][col+i]) 
            {
                return false;
            }
        }

        return true;
    }

    private List<String> constructBoardLayout(boolean[][] board) 
    {
        List<String> layout = new ArrayList<>();
        for (int i = 0; i < board.length; i++) 
        {
            StringBuilder rowBuilder = new StringBuilder();
            for (int j = 0; j < board.length; j++) 
            {
                if (board[i][j]) 
                {
                    rowBuilder.append('Q');
                } 
                else 
                {
                    rowBuilder.append('.');
                }
            }
            layout.add(rowBuilder.toString());
        }
        return layout;
    }

    
}
