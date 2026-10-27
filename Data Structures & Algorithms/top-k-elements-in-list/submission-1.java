// DB Done (8/10)

class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer,Integer> map = new TreeMap<>();

        for(int i = 0 ; i<nums.length ; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 1) + 1); 
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
 
        int[] result = new int[k];

        for (int i = 0; i < k; i++) 
        {
            result[i] = entryList.get(i).getKey();
        }
        
        return result;
    }
}
