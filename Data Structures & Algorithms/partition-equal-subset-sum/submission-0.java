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

        return f(nums,k,nums.length-1);
    }
    private boolean f(int[] nums, int k, int indx)
    {
        if(k == 0) return true;
        if(indx == 0) return nums[0]==k;

        boolean nottake = f(nums,k,indx-1);
        boolean take = false;
        if(nums[indx]<k) take = f(nums,k-nums[indx],indx-1);

        return take || nottake;
    }
}
