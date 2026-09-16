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

                    while (j < max && nums[j] == nums[j - 1]) j++;
                    while (j < max && nums[max] == nums[max + 1]) max--;
                }
                else if (current < target) 
                {
                    j++; // Sum is too small, we need a larger value
                } 
                else 
                {
                    max--; // Sum is too big, we need a smaller value
                }
            }
            
        }
        return result;
    }
}
