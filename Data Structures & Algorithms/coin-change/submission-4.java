class Solution {
    public int coinChange(int[] coins, int target) 
    {
       
        int[] curr = new int[target+1];
        int[] prev = new int[target+1];
        for(int i = 0 ; i<=target ; i++)
        {
            if(i % coins[0] == 0) prev[i] = i/coins[0];
            else prev[i] = (int) 1e9;
        }

        for(int indx = 1 ; indx<coins.length ; indx++)
        {
            for(int trgt = 0 ; trgt<=target ; trgt++ )
            {
                int nottake = 0 + prev[trgt];

                int take = Integer.MAX_VALUE;
                if(coins[indx]<=trgt) take = 1 + curr[trgt-coins[indx]];

                curr[trgt] = Math.min(take,nottake);
            }
            prev = curr.clone();
        }

        int ans = prev[target];
        return (ans >= 1e9) ? -1 : ans; 
        
    }
    
}
