class Solution {
    public int rob(int[] nums) 
    {
        int n = nums.length-1;
        return help(n,nums);

    }
    private int help(int indx , int[] nums)
    {
        if(indx == 0) return nums[indx];
        if(indx < 0) return 0;

        int pick = nums[indx] + help(indx-2 , nums);
        int notpick = help(indx-1 , nums);

        return Math.max(pick,notpick);
    }
}
