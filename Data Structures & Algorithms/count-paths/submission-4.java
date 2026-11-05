class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[] prev = new int[n];
        int[] curr = new int[n];
        
        for(int i = 0 ; i< m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(i==0 && j==0) curr[j] = 1;
                else
                {
                    if(j>0) curr[j] = curr[j-1] + prev[j];
                    else curr[j] =  prev[j];
                }
            }
            prev = curr.clone();
        }
        return prev[n-1];
    }
}
