
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) 
    {
        res = new ArrayList<>();
        
        helper(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    // 'visited' is passed in the argument to perfectly keep track of what is still "unprocessed"
    private void helper(List<Integer> p, int[] nums, boolean[] visited)
    {
        // Base Case: If our processed path length matches the input length, we are done!
        if (p.size() == nums.length)
        {
            res.add(new ArrayList<>(p));
            return;
        }

        // Loop through all indices to find elements that are still "unprocessed" (not visited)
        for (int i = 0; i < nums.length; i++)
        {
            // If the argument tracker says this element is already used in this branch, skip it
            if (visited[i]) continue;

            // 1. Choose: Add to processed list and flag the index as visited inside the argument tracking state
            p.add(nums[i]);
            visited[i] = true;

            // 2. Explore: Pass the updated tracking states deeper down the call stack
            helper(p, nums, visited);

            // 3. Unchoose: Backtrack to restore states cleanly for the next loop iteration
            visited[i] = false;
            p.remove(p.size() - 1);
        }
    }
}
