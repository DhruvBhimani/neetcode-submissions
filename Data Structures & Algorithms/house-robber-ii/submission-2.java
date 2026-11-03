class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length == 1) return nums[0];
        int take,curr;
        int prev = nums[0],prev2 = 0;

        for(int i = 1 ; i < nums.length-1 ; i++)
        {
            if(i > 1) take = nums[i]+ prev2;
            else take = nums[i];

            int nottake = prev;

            curr = Math.max(take,nottake);

            prev2 = prev;
            prev = curr;
        } 

        prev = nums[1];
        prev2 = 0;

        for(int i = 2 ; i < nums.length ; i++)
        {
            if(i > 1) take = nums[i]+ prev2;
            else take = nums[i];

            int nottake = prev;

            curr = Math.max(take,nottake);

            prev2 = prev;
            prev = curr;
        } 
        return Math.max(prev,prev);
        
    }
}
