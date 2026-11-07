class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp)
        {
            java.util.Arrays.fill(row, -1);
        }

        int ans = helper(coins.length-1 , amount , coins , dp);
        return (ans >= 1e9) ? -1 : ans; 
        
    }
    private int helper(int indx, int target , int[] coins , int[][] dp)
    {
        if(indx == 0)
        {
            if(target % coins[0] == 0) return target/coins[0];
            return (int) 1e9;
        }
        if(dp[indx][target] != -1) return dp[indx][target];
        
        int nottake = 0 + helper(indx-1,target,coins ,dp);

        int take = Integer.MAX_VALUE;
        if(coins[indx]<=target) take = 1 + helper(indx,target-coins[indx],coins,dp);

        return dp[indx][target] = Math.min(take,nottake);
    }
}
