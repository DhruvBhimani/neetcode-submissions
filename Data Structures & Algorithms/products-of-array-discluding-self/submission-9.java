// DB Done (10/10)

class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int[] ans = new int[nums.length];
        int pro=1;
        int count=0;

        for(int i = 0 ; i<nums.length; i++)
        {
            if(nums[i]!=0)
            {
                pro *= nums[i];
            }
            else
            {
                count++;
            }
            
        }

        if(count>1) return ans;

        for(int i = 0 ; i<nums.length; i++)
        {
            if(count ==1) 
            {
                if(nums[i]==0) ans[i] = pro;
            }
            else
            {
                ans[i] = pro/nums[i]; 
            }
              
        }
        
        return ans;
        
    }
}  
