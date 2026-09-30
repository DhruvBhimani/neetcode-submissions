class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
        Set<Integer> set = new HashSet<>();

        for(int i=0 ; i < nums.length ; i++)
        {
            if(set.contains(nums[i]) ) return false;

            set.add(nums[i]);
        }    
        return true;
    }
}