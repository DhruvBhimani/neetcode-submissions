class Solution {
    public int rob(int[] nums) 
    {

        int take,curr;
        int prev = nums[0],prev2 = 0;

        for(int i = 1 ; i < nums.length ; i++)
        {
            if(i > 1) take = nums[i]+ prev2;
            else take = nums[i];

            int nottake = prev;

            curr = Math.max(take,nottake);

            prev2 = prev;
            prev = curr;
        } 
        return prev;
    }
}
