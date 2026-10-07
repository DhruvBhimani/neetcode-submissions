class Solution 
{
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<Integer> p = new ArrayList<>();
        return helper(p, nums, target, 0);   
    }
    private List<List<Integer>> helper(List<Integer> p, int[] nums,int target, int index)
    {
        List<List<Integer>> list = new ArrayList<>();

        if (target == 0)
        {
            list.add(new ArrayList<>(p));
            return list;
        }
        if (target < 0)
        {
            return list;
        }
        for (int i = index; i < nums.length; i++)
        {
            int curr = nums[i];

            p.add(curr);

            // Explore: Recursively collect all successful branches down the ladder
            // (Pass 'i' as the index so the next frame is allowed to reuse the same number!)
            List<List<Integer>> tmp = helper(p, nums, target - curr, i);
            list.addAll(tmp);

            // Unchoose: Clean up our workspace list to evaluate the next loop element properly
            p.remove(p.size() - 1);
        }
        return list;
    }
}
