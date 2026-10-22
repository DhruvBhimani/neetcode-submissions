class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, nums, ans, curr, target,0);
        return ans;
    }
    private void backtrack(int index, int[] nums, List<List<Integer>> ans, List<Integer> curr, int target, int sum)
    {
        if(sum > target) return;

        if(sum == target)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (index == nums.length) return;

        curr.add(nums[index]);
        backtrack(index, nums, ans, curr, target, sum + nums[index]);

        curr.remove(curr.size()-1);
        backtrack(index+1, nums, ans, curr, target, sum);

    }
}
