class Solution {
    public int change( int amount,int[] coins) 
    {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp)
        {
            java.util.Arrays.fill(row, -1);
        }
        return helper(coins.length-1 , amount , coins , dp);
        
    }
    private int helper(int indx, int target , int[] coins , int[][] dp)
    {
        if(target == 0) return 1;
        if(indx == 0)
        {
            if(target % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[indx][target] != -1) return dp[indx][target];

        int nottake =  helper(indx-1,target,coins,dp);

        int take = 0;
        if(coins[indx]<=target) take =  helper(indx,target-coins[indx],coins,dp);

        return dp[indx][target] = take+nottake;
    }
}
