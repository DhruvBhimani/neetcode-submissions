class Solution {
    public int findTargetSumWays(int[] nums, int target) 
    {
        int totalSum = 0;
        for (int i : nums) 
        {
            totalSum += i;
        }

        // Edge Cases: If the target is mathematically impossible to reach
        if ((totalSum + target) % 2 != 0 || totalSum < Math.abs(target)) {
            return 0;
        }
        
        // This is our new modified target (S1)
        int s1 = (totalSum + target) / 2;

        // DP table initialized with -1 to cache subset counts
        int[][] dp = new int[nums.length][s1 + 1];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return f(dp, nums, s1, nums.length - 1);
    }

    private int f(int[][] dp, int[] nums, int k, int indx) {
        // Base Case 1: If we processed all elements, check if our target reached 0
        if (indx < 0) {
            return (k == 0) ? 1 : 0;
        }

        // Return cached count if already calculated
        if (dp[indx][k] != -1) {
            return dp[indx][k];
        }

        // Instead of boolean ||, we ADD the total variations from both choices
        int nottake = f(dp, nums, k, indx - 1);
        
        int take = 0;
        // Changed to '<=' so we can match the exact target boundaries
        if (nums[indx] <= k) {
            take = f(dp, nums, k - nums[indx], indx - 1);
        }

        // Cache and return total combinations
        return dp[indx][k] = take + nottake;
    }
}
