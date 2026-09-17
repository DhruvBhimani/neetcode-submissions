class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        // again 1
        Map<Integer,Integer> ans = new HashMap<>();
        for(int i = 0 ; i< nums.length ; i++)
        {
            ans.put(nums[i], i);
        }
        for(int i = 0 ; i< nums.length ; i++)
        {
            int need = target - nums[i];

            if(ans.containsKey(need) && ans.get(need)!= i)
            {
                return new int[]{i,ans.get(need)};
            }

        }
        return new int[0];
    }
}
