// DB Done (10/10)

class Solution {
    public int maxProfit(int[] prices) 
    {
        if(prices.length <= 1) return 0;
        int low = prices[0],max=0;
        
        for(int i = 1 ; i < prices.length ; i++)
        {
            if(low > prices[i]) 
            {
                low = prices[i];
            }
            else 
            {
                max = Math.max(max , prices[i] - low);
            }
        }
        return max;
    }
}
