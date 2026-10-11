class pair
{
    int first;
    int second;
    public pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int ans = 0;

        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col < m ; col++)
            {
                if(visited[row][col] == false && grid[row][col] == '1')
                {
                    ans++;
                    bfs(row, col, visited, grid );
                }
            }
        }
        
        return ans;
    }

    private void bfs(int row, int col, boolean[][] visited, char[][] grid)
    {
        visited[row][col] = true;
        Deque<pair> q = new ArrayDeque<>();

        int n = grid.length;
        int m = grid[0].length;

        q.offer(new pair(row,col));

        while(!q.isEmpty())
        {
            int ro = q.peek().first;
            int co = q.peek().second;

            q.poll();

            for(int delrow = -1; delrow<= 1  ; delrow++)
            {
                for(int delcol = -1; delcol<= 1  ; delcol++)
                {
                    if ((delrow != 0 && delcol != 0) || (delrow == 0 && delcol == 0)) 
                    {
                        continue;
                    }
                    
                    int newrow = ro + delrow;
                    int newcol = co + delcol;

                    if(newrow>=0 && newrow<n && newcol>=0 && newcol < m && grid[newrow][newcol] == '1' && visited[newrow][newcol] == false)
                    {
                        visited[newrow][newcol] = true;
                        q.offer(new pair(newrow, newcol));
                    }
                }
            }
        }


    }
}


