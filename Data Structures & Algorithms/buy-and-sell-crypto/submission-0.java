class Solution 
{
    public int maxProfit(int[] prices) 
    {
        if(prices.length < 2)
        {
            return 0;
        }
        int max = 0;
        int j = 0;
        Set<Integer> ans = new HashSet<>();

        for(int i = 0 ; i< prices.length ; i++)
        {
            ans.add(prices[i]);
            j = prices[i] -  ans.stream().min(Integer::compare).orElse(Integer.MAX_VALUE);
            if(j>max)
            {
                max = j;
            }
        }
        return max;
    }
}
