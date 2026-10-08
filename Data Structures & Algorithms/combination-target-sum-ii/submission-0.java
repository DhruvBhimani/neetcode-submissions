class Solution 
{
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) 
    {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);

        helper(nums, target, curr, 0);
        return res;
    }

    private void helper(int[] nums, int target, List<Integer> curr, int index)
    {
        if(target == 0 )
        {
            res.add(new ArrayList(curr));
            return;
        }
        if(target < 0 || index >= nums.length)
        {
            return;
        }

        curr.add(nums[index]);
        // Move to the exact next slot (index + 1) so duplicate copies can be added together if needed
        helper(nums, target - nums[index], curr, index + 1);
        curr.remove(curr.size() - 1); 

        // Find the next UNIQUE number to skip all identical candidate branches -----at this level------ 
        // so if 2,2,2,3 and 2 is already proccesed we dont get other 2 , if we get other 2 duplicates
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) 
        {
            nextIndex++; 
        }
        
        // Explore the path where this value category is completely bypassed
        helper(nums, target, curr, nextIndex);
    }
}
