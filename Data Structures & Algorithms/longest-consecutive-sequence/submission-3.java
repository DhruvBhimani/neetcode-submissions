class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        Arrays.sort(nums);
        int count = 0;
        int max = 1;

        if(nums.length == 0)
        {
            return 0;
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
