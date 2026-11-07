class Solution {
    public int coinChange(int[] coins, int target) 
    {
        int[][] dp = new int[coins.length][target+1];
        
        for(int i = 0 ; i<=target ; i++)
        {
            if(i % coins[0] == 0) dp[0][i] = i/coins[0];
            else dp[0][i] = (int) 1e9;
        }

        for(int indx = 1 ; indx<coins.length ; indx++)
        {
            for(int trgt = 0 ; trgt<=target ; trgt++ )
            {
                int nottake = 0 + dp[indx-1][trgt];

                int take = Integer.MAX_VALUE;
                if(coins[indx]<=trgt) take = 1 + dp[indx][trgt-coins[indx]];

                dp[indx][trgt] = Math.min(take,nottake);
            }
        }

        int ans = dp[coins.length-1][target];
        return (ans >= 1e9) ? -1 : ans; 
        
    }
    
}
