// DB Done (8/10)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int n = 0 ; n < nums.length-2 ; n++)
        {
            if(n!=0 && nums[n] == nums[n-1]) continue;
            int i = n+1;
            int j = nums.length - 1;
            while(i<j)
            {
          
                if(nums[i] + nums[j] + nums[n] == 0) 
                {
                    ans.add(List.of(nums[n], nums[i], nums[j]));
                    i++;
                    while(i<j && nums[i] == nums[i-1]) i++;
                }
                if(nums[i] + nums[j] + nums[n] > 0) j--;
                if(nums[i] + nums[j] + nums[n] < 0) i++;
                
            }
        }
        return ans;
        
    }
}
