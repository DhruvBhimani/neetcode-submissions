class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int[] ans = new int[nums.length];
        
        int ttl = 1;
        int ttl2 = 1;
        int count = 0;
        int d = 0;
        Arrays.fill(ans, 1);

        for(int i = 0 ; i < nums.length ; i ++)
        {
            if(nums[i]==0)
            {
                count++;
                d=i;

            }
            ttl = nums[i] * ttl;  
        }

        if(count>1)
        {
            Arrays.fill(ans, 0);
        }
        else if(count == 1)
        {
            Arrays.fill(ans, 0);
            for( int i = 0 ; i< nums.length ; i++)
            {
                if(i!=d)
                {
                    ttl2 = ttl2 * nums[i];
                }
            }
            ans[d]= ttl2;
        }
        else if(count < 1)
        {
            for(int j = 0 ; j< nums.length ; j++)
            {
                ans[j] = ttl/ nums[j];
            }
        }
        
        

        return ans;
    }
}  
