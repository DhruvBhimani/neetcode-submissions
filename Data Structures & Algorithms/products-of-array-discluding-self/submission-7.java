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
            if(nums[i]==0)
            {
                count++;
            }
            pro *= nums[i];
        }

        int zeroindex=0;
        int newpro=1;
        if(count == 1)
        {
            for(int i = 0 ; i<nums.length; i++)
            {
                if(nums[i]!=0)
                {
                    ans[i] = 0;
                    newpro *= nums[i];
                }
                else
                {
                    zeroindex = i;
                }

            }
            ans[zeroindex] = newpro;
        }
        
        else if(count>1) return ans;

        else
        {
            for(int i = 0 ; i<nums.length; i++)
            {
                ans[i] = pro/nums[i];
                
            }
        }
        return ans;
        
    }
}  
