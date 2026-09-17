class Solution {
    public int maxProfit(int[] prices) 
    {
        if(prices.length < 2)
        {
            return 0;
        }    

        int minprice = prices[0];
        int max = 0;

        for(int i = 1 ; i< prices.length ; i ++)
        {
            if(prices[i]<minprice)
            {
                minprice = prices[i];
            }
            else
            {
                int crrnt = prices[i] - minprice;
                if(crrnt>max)
                {
                    max = crrnt;
                }
            }
        }
        return max;
    }
}
