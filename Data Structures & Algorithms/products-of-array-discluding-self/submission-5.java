class Solution {
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
        int col=0;
        int pro1=1;
        if(count == 1)
        {
            for(int i = 0 ; i<nums.length; i++)
            {
                if(nums[i]!=0)
                {
                    ans[i] = 0;
                    pro1 *= nums[i];
                }
                else
                {
                    col = i;
                }

            }
            ans[col] = pro1;
        }
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
