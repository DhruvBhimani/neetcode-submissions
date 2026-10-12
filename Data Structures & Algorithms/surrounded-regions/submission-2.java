class Solution {
    public void solve(char[][] board) 
    {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i<n ; i++)
        {
            for( int j = 0 ; j<m ;j++)
            {
                // traverse edges when 'O'
                
                if((j==0 || i == 0 || j == m-1 || i == n-1) && (board[i][j] == 'O'))
                {
                    
                    vis[i][j] = true;
                    dfs(i,j,vis,board);
                }
            }
        } 
        for(int i = 0 ; i<n ; i++)
        {
            for( int j = 0 ; j<m ;j++)
            {
                if(vis[i][j]== false && board[i][j]== 'O')
                {
                    board[i][j] = 'X';
                }
            }
        } 

    }
    private void dfs(int i , int j , boolean[][] vis, char[][] board)
    {
        int n = board.length;
        int m = board[0].length;

        int[] row = {0,1,0,-1};
        int[] col = {1,0,-1,0};

        for(int n1 = 0 ; n1<4 ; n1++)
        {
            int nrow = i+row[n1];
            int ncol = j+col[n1];

            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && board[nrow][ncol]=='O'
            && vis[nrow][ncol]== false)
            {
                vis[nrow][ncol] = true;
                dfs(nrow,ncol,vis,board);
            }
        }
        return;
    }
}
