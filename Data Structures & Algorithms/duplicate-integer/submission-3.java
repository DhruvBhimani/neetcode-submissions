class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
            Set<Integer> d = new HashSet<>();

            for(int i = 0 ; i< nums.length ; i++)
            {
                if(d.contains(nums[i]))
                {
                    return true;
                }
                d.add(nums[i]);
            }
            return false;
    }
}