class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) 
    {
        res = new ArrayList<>();

        List<Integer> up = new ArrayList<>();
        for (int num : nums) 
        {
            up.add(num);
        }

        helper(new ArrayList<>(), up);
        return res;
        
    }
    private void helper(List<Integer> p, List<Integer> up)
    {
        if(up.isEmpty())
        {
            res.add( new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < up.size(); i++)
        {
            int cur = up.get(i);

            p.add(cur);
            
            // Create a temporary copy of 'up' and remove the item at index 'i' to pass it down
            List<Integer> remainingUnprocessed = new ArrayList<>(up);
            remainingUnprocessed.remove(i);

            // Recursively pass the updated processed and unprocessed lists to the next frame
            helper(p, remainingUnprocessed);

            // 2. Unchoose: Backtrack and pull 'cur' back out of 'p' to test the next loop iteration properly
            p.remove(p.size() - 1);
        }
    }
}
