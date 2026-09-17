class Solution {
    public int[] twoSum(int[] nums, int target) 
    {       
        //again 2
        Map<Integer, Integer> ans = new HashMap<>();
       
        for (int i = 0; i < nums.length; i++) 
        {
            int need = target - nums[i];
    
            if (ans.containsKey(need)) 
            {
                return new int[]{ans.get(need), i};
            }
            ans.put(nums[i], i);
        }      
        return new int[0];
    }
}
