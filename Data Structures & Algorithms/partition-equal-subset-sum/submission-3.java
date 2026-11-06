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

        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];

        prev[0] = curr[0] = true;

        for(int indx = 1 ; indx<nums.length ; indx++)
        {
            for(int target = 1 ; target<=k ; target++)
            {
                boolean nottake = prev[target];
                boolean take = false;
                if(nums[indx]<=target) take = prev[target-nums[indx]];

                curr[target] = (take || nottake);

            }
            prev = curr;
        }
        return prev[k];
    }
    
}
