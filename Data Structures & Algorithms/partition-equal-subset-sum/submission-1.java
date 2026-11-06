class Solution {
    public boolean canPartition(int[] nums) 
    {
        int k=0;
        for(int i : nums)
        {
            k += i;
        }
        if(k%2 != 0) return false;
        k = k/2;

        int[][] dp = new int[nums.length][k+1];
        for (int[] row : dp) 
        {
            java.util.Arrays.fill(row, -1);
        }

        return f(dp ,nums,k,nums.length-1);
    }
    private boolean f(int[][] dp , int[] nums, int k, int indx)
    {
        if(k == 0) return true;
        if(indx == 0) return nums[0]==k;
        if(dp[indx][k] != -1) return dp[indx][k] == 1;

        boolean nottake = f(dp,nums,k,indx-1);
        boolean take = false;
        if(nums[indx]<=k) take = f(dp, nums,k-nums[indx],indx-1);

        dp[indx][k] = (take || nottake) ? 1 : 0;

        return dp[indx][k]==1;
    }
}
