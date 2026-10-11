class Pair
{
    int first;
    int second;
    int time;
    public Pair(int first, int second, int time)
    {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        Deque<Pair> q = new ArrayDeque<>();

        boolean[][] visited = new boolean[n][m];
        int cntfresh = 0;

        for(int i = 0 ; i<n ; i++)
        {
            for(int j = 0 ; j< m ; j++)
            {
                if(grid[i][j]== 2)
                {
                    q.offer(new Pair(i , j , 0));
                    visited[i][j] = true;
                }
                if(grid[i][j] == 1) 
                {
                    cntfresh++;
                }
            }
        }

        int ans=0,cnt = 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,-1,0,1};

        while(!q.isEmpty())
        {
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().time;

            ans = Math.max(ans,t);

            q.poll();

            for(int i = 0 ; i<4 ; i++)
            {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && ncol >=0 && nrow < n && ncol < m 
                && visited[nrow][ncol]== false && grid[nrow][ncol]==1)
                {
                    q.offer(new Pair(nrow , ncol , t+1));
                    cnt++;
                    visited[nrow][ncol] = true;
                }
            }
        }

        if(cnt == cntfresh)
        {
            return ans;
        }
        return -1;
    }
}
