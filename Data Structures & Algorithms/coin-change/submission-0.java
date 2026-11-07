class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        return helper(coins.length-1 , amount , coins);
        
    }
    private int helper(int indx, int target , int[] coins)
    {
        if(indx == 0)
        {
            if(target % coins[0] == 0) return target/coins[0];
            return -1;
        }
        int nottake = 0 + helper(indx-1,target,coins);

        int take = Integer.MAX_VALUE;
        if(coins[indx]<=target) take = 1 + helper(indx,target-coins[indx],coins);

        return Math.min(take,nottake);
    }
}
