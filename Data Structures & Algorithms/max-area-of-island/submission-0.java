
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
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col < m ; col++)
            {
                if(visited[row][col] == false && grid[row][col] == 1)
                {
                    bfs(row, col, visited, grid );
                }
            }
        }
        
        return ans;
    }

    private void bfs(int row, int col, boolean[][] visited, int[][] grid)
    {
        visited[row][col] = true;
        Deque<pair> q = new ArrayDeque<>();

        int n = grid.length;
        int m = grid[0].length;
        int curr = 0;

        q.offer(new pair(row,col));

        while(!q.isEmpty())
        {
            curr++;
            ans = Math.max(curr,ans);
            int ro = q.peek().first;
            int co = q.peek().second;

            q.poll();

            int[] delrow = {1,0,-1,0};
            int[] delcol = {0,1,0,-1};

            for(int i = 0; i< 4  ; i++)
            {
                    
                int newrow = ro + delrow[i];
                int newcol = co + delcol[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol < m && grid[newrow][newcol] == 1 && visited[newrow][newcol] == false)
                {
                    visited[newrow][newcol] = true;
                    q.offer(new pair(newrow, newcol));
                }
                
            }
        }


    }
}
