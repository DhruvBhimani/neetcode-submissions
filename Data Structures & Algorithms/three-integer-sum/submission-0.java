class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i =0 ; i<nums.length - 2 ; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) 
            {
                continue;
            }
            int target = -(nums[i]);
            int max = nums.length -1;

            int j = i+1;

            while(j<max)
            {
                int current = nums[j]+nums[max];

                if(current == target)
                {
                    result.add(Arrays.asList(nums[i],nums[j],nums[max]));
                    j++;
                    max--;
                }
                else
                {
                    if(j+1 == max)
                    {
                        j++;
                        max = nums.length -1;
                    }
                    else
                    {
                        max--;
                    }
                    
                }
            }
            
        }
        return result;
    }
}
