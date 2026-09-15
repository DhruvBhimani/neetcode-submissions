class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int[] ans = new int[nums.length];
        
        int ttl = 1;
        int ttl1 = 1;
        Arrays.fill(ans, 1);

        for(int i = 0 ; i < nums.length ; i ++)
        {
            ttl = nums[i] * ttl;  
        }
        
        for(int j = 0 ; j< nums.length ; j++)
        {
            if(ttl == 0 )
            {
                if (nums[j] != 0) 
                {
                    ans[j] = 0;
                }
                if (nums[j] == 0)
                {
                    ttl1 = 1;
                    for(int i = 0 ; i < nums.length ; i ++)
                    {
                        if(i!=j)
                        {
                            ttl1 = nums[i] * ttl1; 
                        }
                         
                    }
                    ans[j] = ttl1;
                }
            }
            else
            ans[j] = ttl/ nums[j];
        }

        return ans;
    }
}  
