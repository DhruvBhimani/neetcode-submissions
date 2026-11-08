class Solution {
    public int change( int amount,int[] coins) 
    {
        return helper(coins.length-1 , amount , coins);
        
    }
    private int helper(int indx, int target , int[] coins)
    {
        if(target == 0) return 1;
        if(indx == 0)
        {
            if(target % coins[0] == 0) return 1;
            return 0;
        }
        int nottake =  helper(indx-1,target,coins);

        int take = 0;
        if(coins[indx]<=target) take =  helper(indx,target-coins[indx],coins);

        return take+nottake;
    }
}
