class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        return helper(m-1,n-1); 
    }
    private int helper(int m, int n)
    {
        if(m==0 && n == 0) return 1;
        if(m<0 || n<0) return 0;

        int up = helper(m-1,n);
        int left = helper(m,n-1);

        return up+left;
    }
}
