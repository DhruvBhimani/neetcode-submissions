class Solution {
    public boolean canPartition(int[] nums) 
    {
        int k=0;
        for(int i : nums)
        {
            k += i;
        }
        if(k%2 == 1) return false;
        k = k/2;

        boolean[][] dp = new boolean[nums.length][k+1];
        for(int i = 0 ; i < nums.length ; i++)
        {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for(int indx = 1 ; indx<nums.length ; indx++)
        {
            for(int target = 1 ; target<=k ; target++)
            {
                boolean nottake = dp[indx-1][target];
                boolean take = false;
                if(nums[indx]<=target) take = dp[indx-1][target-nums[indx]];

                dp[indx][target] = (take || nottake);

            }
        }
        return dp[nums.length-1][k];
    }
    
}
