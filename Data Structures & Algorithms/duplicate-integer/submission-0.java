class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
        for (int i=0;i<nums.length;i++)
        {
            int currnt = nums[i];
            
            for (int j=0;j<nums.length;j++)
            {
                if(i!=j && nums[j]==currnt)
                {
                    return true;
                }
            }
        }
        return false;
    }
}