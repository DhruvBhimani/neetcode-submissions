class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, nums, ans, curr);
        return ans;
        
    }
    private void backtrack(int index, int[] nums, List<List<Integer>> ans, List<Integer> curr)
    {
        if(index == nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        backtrack(index+1, nums, ans, curr);

        curr.remove(curr.size()-1);
        backtrack(index+1, nums, ans, curr);

    }
}
