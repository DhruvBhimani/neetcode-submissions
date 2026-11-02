class Solution {
    public int rob(int[] nums) 
    {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1 ; i < nums.length ; i++)
        {
            int take;
            if(i > 1) take = nums[i]+ dp[i-2];
            else take = nums[i];

            int nottake = dp[i-1];

            dp[i] = Math.max(take,nottake);
        } 
        return dp[nums.length-1];
    }
}
