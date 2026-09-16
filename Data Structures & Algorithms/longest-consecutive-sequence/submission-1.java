class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Arrays.sort(nums);
        int count = 0;
        int max = 0;

        if(nums.length == 1)
        {
            return 1;
        }

        for(int i = 0 ; i < nums.length-1 ; i++)
        {
            if(nums[i+1]== nums[i]+1 || nums[i+1]== nums[i])
            {
                count++;
                if(count>max)
                {
                    max = count;
                }
            }
            else
            {
                count = 0;
            }
            
        }
        return max;

    }
}
