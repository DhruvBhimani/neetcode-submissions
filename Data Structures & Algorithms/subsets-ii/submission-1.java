class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(0, nums, ans, curr);
        return ans;
    }
    private void backtrack(int index, int[] nums, List<List<Integer>> ans, List<Integer> curr)
    {
        ans.add(new ArrayList<>(curr)); 

        for (int i = index; i < nums.length; i++) 
        {
            // 2. Skip duplicate elements at the same recursion depth
            if (i > index && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            // Move to i + 1 because each element can only be used once
            backtrack(i + 1, nums, ans, curr);
            curr.remove(curr.size() - 1);
        }

    }
}
