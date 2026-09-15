class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer,Integer> d = new HashMap<>();

        for(int i = 0 ; i<nums.length ; i++)
        {
            int check = target - nums[i];
            if(d.containsKey(check))
            {
                return new int[] { d.get(check), i };
            }

            d.put(nums[i], i);
        }    

        return new int[0];
    }
}
