class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        backtrack(0,nums,curr, ans,vis);

        return ans;
    }
    private void backtrack(int index,int[] nums,List<Integer> curr, List<List<Integer>> ans,boolean[] vis)
    {
        if(curr.size() == nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0 ; i<nums.length;i++)
        {
            if(vis[i] == false)
            {
                vis[i] = true;
                curr.add(nums[i]);
                backtrack(i+1 , nums, curr, ans , vis);

                curr.remove(curr.size()-1);
                vis[i] = false;

            }
        }


    }
}
