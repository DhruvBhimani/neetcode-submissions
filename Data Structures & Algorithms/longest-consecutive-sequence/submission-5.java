class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Arrays.sort(nums);
        int count = 1;
        int max = 1;

        if(nums.length == 0)
        {
            return 0;
        }

        for(int i = 0 ; i < nums.length-1 ; i++)
        {
            if(nums[i+1]== nums[i]+1)
            {
                count++;
                if(count>max)
                {
                    max = count;
                }
            }
            else if(nums[i+1]== nums[i])
            {
                continue;
            }
            else
            {
                count = 1;
            }
            
        }
        return max;

    }
}
