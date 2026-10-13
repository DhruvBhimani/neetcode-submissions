class Solution 
{
    public void islandsAndTreasure(int[][] grid) 
    {
        Deque<int[]> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i< n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(new int[]{i,j});
                }
            }
        }

        if(q.size() == 0) return;

        int[] rows = {0,1,0,-1};
        int[] cols = {1,0,-1,0};

        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int i = 0 ; i<4; i++)
            {
                int r = row + rows[i];
                int c = col + cols[i];

                if(r>=0 && c>=0 && r<n && c<m && grid[r][c] == Integer.MAX_VALUE)
                {
                    q.add(new int[] {r,c});
                    grid[r][c] = grid[row][col] + 1;
                }
            }
        }
        
    }
}
