class Solution 
{
    
    public int rob(int[] nums) 
    {
        int n = nums.length-1;
        int[] dp = new int[n+1];
        return help(n,nums,dp);

    }
    private int help(int indx , int[] nums , int[] dp)
    {
        if(indx == 0) return nums[indx];
        if(indx < 0) return 0;
        if(dp[indx]!= 0) return dp[indx];

        int pick = nums[indx] + help(indx-2 , nums , dp);
        int notpick = help(indx-1 , nums ,dp);

        return dp[indx] = Math.max(pick,notpick);
    }
}
