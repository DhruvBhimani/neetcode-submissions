class Solution {
    public int climbStairs(int n) 
    {
        if(n == 0 || n == 1) return 1;

        int prev2 = 1;
        int prev = 1;
        int curr = 0;

        for(int i = n-2 ; i>=0 ; i--)
        {
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }    
        return curr;
    }
}
