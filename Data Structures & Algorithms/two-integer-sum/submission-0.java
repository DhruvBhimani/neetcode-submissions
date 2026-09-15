class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = 0 ; j < nums.length && j!=i ; j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    int[] d = new int[2];
                    if(i<j)
                    {
                        d[0]=i;
                        d[1]=j;
                    }
                    else
                    {
                        d[1]=i;
                        d[0]=j;
                    }
                    
                    return d;
                }
            }
        }
        return new int[0];
    }
}
